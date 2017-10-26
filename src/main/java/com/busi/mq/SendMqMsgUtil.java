package com.busi.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * mq消息发送工具类
 * Created by zzy on 2017/8/15.
 */
@Component
public class SendMqMsgUtil {

    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 该方法发送消息需要先创建好队列（客户端创建队列 Customer），通过交换器 routingKey  到队列
     *
     * @param msg
     */
    public void sendMessage(Object msg){
        //rabbitTemplate.convertAndSend("hello1","this is first mq");
        rabbitTemplate.convertAndSend("exchange2","queue_one_key1",msg);
        log.info("发送消息：hello");
    }
}
