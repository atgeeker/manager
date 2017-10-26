package systemman;

import com.busi.domain.User;
import com.busi.mq.SendMqMsgUtil;
import com.busi.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by zzy on 2017/8/15.
 */
public class MqTest extends TestBase {
    @Autowired
    private SendMqMsgUtil sendMqMsgUtil;
    @Autowired
    private UserService userService1;

    @Test
    public void mqTest(){
        User user = new User();
        user.setId(1L);
        user.setIpaddress("127.0.0.1");
        user.setUsername("zhangsan");
        user.setSalt("123");
        user.setPassword("1292019289292929");
        user.setStatus("1");
        for(int i=0;i<20;i++){
            user.setId(Long.parseLong((i+1)+""));
            System.out.println("发送第【"+(i+1)+"】条消息");
           sendMqMsgUtil.sendMessage(user);
        }
    }

    @Test
    public void userAddTest(){
        userService1.addUser();
    }
}
