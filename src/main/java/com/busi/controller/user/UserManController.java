package com.busi.controller.user;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.busi.controller.BaseController;
import com.busi.controller.ReturnData;
import com.busi.service.UserService;
import com.busi.util.SystemUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.busi.domain.User;
import com.busi.domain.UserExample;
import com.busi.domain.UserExample.Criteria;
import com.busi.log.LOG;
import com.busi.mapper.UserMapper;
import com.busi.util.StringUtils;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Controller
@RequestMapping("/manuser")
public class UserManController extends BaseController {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    @RequestMapping("/loadadduserpage")
    public String loadPage() {

        log.info("加载添加用户页面");
        return "/busi/userman/adduser";
    }

    /**
     * 添加用户
     *
     * @param request
     * @return
     */
    @LOG(message = "添加用户")
    @RequiresRoles("admin")
    @RequestMapping(value = "/adduser", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData addUser(User user, HttpServletRequest request) {
        ReturnData returnData = new ReturnData();
        String username = user.getUsername();
        log.info("添加用户：" + username);
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        if (userMapper.countByExample(example) > 0) {
            log.info("用户已经存在");
            returnData.setErrorMsg("用户已经存在");
            return returnData;
        }
        user.setIpaddress(SystemUtil.getIpAddr(request));
        userService.addUser(user, returnData);
        return returnData;
    }

    /**
     * 删除用户
     *
     * @param request
     * @param response
     * @return
     */
    @LOG(message = "删除了用户")
    @RequiresPermissions("del")
    @RequestMapping(value = "/delUser", method = {RequestMethod.POST})
    @ResponseBody
    public ReturnData delUserById(HttpServletRequest request, HttpServletResponse response) {
        long id = Long.parseLong(request.getParameter("id"));
        String result = "删除失败";

        Subject subject = SecurityUtils.getSubject();
        User loginUser = (User) subject.getPrincipal();
        String loginUserName = loginUser.getUsername();

        ReturnData returnData = new ReturnData();
        User user = userMapper.selectByPrimaryKey(id);
        if (null != user) {
            if (loginUserName.equals(user.getUsername())) {
                result = "用户不能删除自己";
            } else if ("admin".equals(user.getUsername())) {
                result = "不能删除超级用户";
            } else {
                UserExample example = new UserExample();
                Criteria criteria = example.createCriteria();
                criteria.andIdEqualTo(id);
                int re = userMapper.deleteByExample(example);
                if (1 == re) {
                    result = "刪除成功";
                }
            }
        }
        returnData.setErrorMsg(result);
        return returnData;
    }

    /**
     * 修改用户信息
     *
     * @param request
     * @param map
     * @return
     */
    @LOG(message = "修改用信息")
    @RequestMapping(value = "/edituser", method = {RequestMethod.GET,RequestMethod.POST})
    public String editUser(HttpServletRequest request, User user, ModelMap map, HttpServletResponse response) {
        try {
            if ("post".equalsIgnoreCase(request.getMethod()) && user != null) {
                log.info("修改用户信息");
                String result = "";
                User eUser = userMapper.selectByPrimaryKey(user.getId());
                eUser.setRealname(user.getRealname());

                ReturnData returnData = new ReturnData();
                int re = userMapper.updateByPrimaryKey(eUser);
                if (re >= 1) {
                    //returnData.setErrorMsg("修改成功");
                    result = "修改成功";
                }else{
                    //returnData.setErrorMsg("修改失败");
                    result = "修改失败";
                }
                sendResponse(result, response);
                return null;
            }else{
                log.info("查询用户信息详细");
                String idStr = request.getParameter("id");
                Long id = Long.parseLong(idStr);
                User userQ = userMapper.selectByPrimaryKey(id);
                map.addAttribute("user", userQ);
            }
        } catch (Exception e) {
            log.error("--->",e);
        }

        return "/busi/userman/edituser";
    }

    @RequestMapping("/queryuserpage")
    public String queryUserListPage() {
        return "/busi/userman/userList";
    }

    /**
     * 查询用户信息
     * 需要用解析为jackson的jar包
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping(value = "/queryuser", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> queryUserList(HttpServletRequest request, HttpServletResponse response,
                                             Model model) {
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
        String username = request.getParameter("username");
        log.info("pageSize:" + pageSize + ";pageNumber:" + pageNumber + ";username:" + username);
//		if("0".equals(offset)){
//			offset = "1";
//		}
        Page<User> page = PageHelper.startPage(pageNumber, pageSize);
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(username)) {
            criteria.andUsernameLike("%" + username + "%");
        }

        page = (Page<User>) userMapper.selectByExample(example);

        //model.addAttribute("users", page);
        log.info("size:" + page.getTotal());
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("total", page.getTotal());
        map.put("rows", page);
        return map;
    }

    @RequestMapping("/loadupload")
    public String loadUploadFilePage() {
        return "/busi/userman/uploadfile";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {

        System.out.println("开始");
        String path = request.getSession().getServletContext().getRealPath("upload");
        String fileName = file.getOriginalFilename();
        //        String fileName = new Date().getTime()+".jpg";
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("fileUrl", request.getContextPath() + "/upload/" + fileName);

        return "/result";
    }
}
