package com.busi.mq.orgin;

import com.rabbitmq.client.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 消费者，当队列不存在时创建队列消息
 * Created by zzy on 2017/6/17.
 */
public class Customer2 {

    private static Logger log = LoggerFactory.getLogger(Customer2.class);

    public void revice()throws Exception{
        String QUEUE_NAME = "queue_two";    //队列名称
        String EXCHANGE = "exchange2";    //交换器
        String routing_key = "queue_one_key1";   //路由key

//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setHost("223.85.163.38");
//        factory.setPort(5670);
//        factory.setUsername("admin");
//        factory.setPassword("123456");
//        Connection connection = factory.newConnection();
//        Channel channel = connection.createConnection();

        final Channel channel = MqConnectionFactory.createConnection().createChannel();
        channel.exchangeDeclare(EXCHANGE, BuiltinExchangeType.DIRECT, true);

        //队列参数设置最大长度
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("x-max-length",5);   //设置最大消息 数
        //map.put("x-max-length-bytes",5);   //设置最大长度（以字节  为单位）

        boolean durable = true;  //是否持久化
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
        channel.queueBind(QUEUE_NAME, EXCHANGE,routing_key);   //
        System.out.println(" [Customer] Waiting for messages. To exit press CTRL+C");


        //每次从队列获取的数量
        int prefetchCount = 1 ;
        channel.basicQos(prefetchCount);

        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(" [contentType] - "+properties.getContentType()+";[routing key] - "+envelope.getRoutingKey()+"[Customer] Received '" + message + "'");
                try{
                    doWork();
                }catch (Exception e){
                    log.error("异常-->",e);
                }
            }
        };
        boolean autoAck = true;
        channel.basicConsume(QUEUE_NAME, autoAck, consumer);
    }

    /**
     * 暂停 10 s
     * @throws Exception
     */
    public void doWork() throws Exception{
        Thread.sleep(5000);
    }

    public static void main(String[] args) {
        try{
            new Customer2().revice();
        }catch (Exception e){
            log.error("注册mq异常",e);
        }

    }
}
