package com.busi.controller;

import com.busi.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.busi.log.LOG;

@Controller
@RequestMapping("/mytest")
public class ControllerTest {
	private static Logger log = LoggerFactory.getLogger(ControllerTest.class);

	@Autowired
	private UserService userService1;
	//利用url进行参数传递
	@RequiresPermissions("edits")
	@RequestMapping(value="/test/{msg}",method=RequestMethod.GET)
	@ResponseBody
	public String test(@PathVariable("msg") String msg){
		log.info("this is controller test");
		return "this is controller test:"+msg;
	}
	@LOG(message="点击了你好")
	@RequiresPermissions("edit")
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	@ResponseBody
	public String hello(){
		return "Hello world";
	}
	
	@RequestMapping(value="/bodytest",method=RequestMethod.POST)
	@ResponseBody
	public String bodyTest(@RequestBody String bodyStr){
		log.info("============"+bodyStr);
		userService1.addUser();
		return bodyStr;
	}
}
