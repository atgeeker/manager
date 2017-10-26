package com.busi.mq.orgin;

import com.busi.util.ConfigPropertiesUtil;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.krb5.Config;

/**mq connection 创建工厂
 * Created by zzy on 2017/6/17.
 */
public class MqConnectionFactory {

    private static Logger log = LoggerFactory.getLogger(MqConnectionFactory.class);
    private static Connection connection;

    public static Connection createConnection() throws Exception{
        if(null == connection){
            init();
            return connection;
        }
        return connection;
    }

    private static void init() throws Exception {
        if(log.isDebugEnabled()){
            log.debug("init mq ...");
        }
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(ConfigPropertiesUtil.getInstance().getProperty("mq.host"));
        factory.setPort(ConfigPropertiesUtil.getInstance().getPropertyForInt("mq.port"));
        factory.setUsername(ConfigPropertiesUtil.getInstance().getProperty("mq.username"));
        factory.setPassword(ConfigPropertiesUtil.getInstance().getProperty("mq.password"));
        factory.setVirtualHost(ConfigPropertiesUtil.getInstance().getProperty("mq.vhost"));   //虚拟主机，不同的vhost中队列名称可以一样。
        connection = factory.newConnection();
    }
}
