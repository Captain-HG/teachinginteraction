package com.lzc.teachingInteraction.rabbitmq;

import com.lzc.teachingInteraction.service.QueueService;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public   class MyRabbitmq {


    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpAdmin amqpAdmin;
    @Autowired
    QueueService queueService;
    public void CreateExchange(String  fromUserId,String  toUserId) {
//        创建交换机
//        amqpAdmin.declareExchange(new DirectExchange("lzcDirect.exchange"));
//        System.out.println("创建完成");

//        创建队列
        amqpAdmin.declareQueue(new Queue(fromUserId+"-"+toUserId,true));
        System.out.println("创建队列完成");
        amqpAdmin.declareBinding(new Binding(fromUserId+"-"+toUserId, Binding.DestinationType.QUEUE,"lzcDirect.exchange",fromUserId+toUserId,null));
        queueService.add(fromUserId+"-"+toUserId,fromUserId,toUserId);
    }
    /**
     * 单播（点对点）
     */

    public void contextLoads(String  fromUserId,String  toUserId,String msg) {

        //message需要自己构造一个对象，定义消息体与消息内容
        // rabbitTemplate.send(exchange,routingkey,message);
        //object只需自己传入要发送的对象，自动序列化发送给rabbitmq
        //rabbitTemplate.convertAndSend(exchange,routeingkey,object);
        //map1.put("s2",222);
        //会出现乱码问题
        rabbitTemplate.convertAndSend("lzcDirect.exchange",fromUserId+toUserId,msg);
    }
    /**
     * 接收指定队列中的消息
     */
    public String receive(String queueName) {
        Object o = rabbitTemplate.receiveAndConvert(queueName);
        return o.toString();
    }
}
