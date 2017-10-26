package com.busi.mq.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by zzy on 2017/8/16.
 */
@Service("returnCallBackListener")
public class ReturnCallBackListener implements RabbitTemplate.ReturnCallback{
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("return--message:"+new String(message.getBody())+
                ",replyCode:"+replyCode+",replyText:"+replyText+"," +
                "exchange:"+exchange+",routingKey:"+routingKey);
    }
}
