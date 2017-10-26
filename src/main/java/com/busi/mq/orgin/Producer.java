package com.busi.mq.orgin;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.aspectj.lang.annotation.DeclareError;

/**
 * 生产者没有使用spring 的rabbmitTemplate   目前已经废弃
 * Created by zzy on 2017/6/17.
 */
@Deprecated
public class Producer {
    public void send() throws Exception{

        String QUEUE_NAME = "HELLO WORLD1";

        Connection connection = MqConnectionFactory.createConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        for(int i=0;i<5;i++){
            String message = "Hello World---"+i+"!";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("MqTest.main send message:"+message );
        }


        //关闭通道和连接
        channel.close();
        connection.close();
    }

    public static void main(String[] args) throws Exception{
        new Producer().send();
    }
}
