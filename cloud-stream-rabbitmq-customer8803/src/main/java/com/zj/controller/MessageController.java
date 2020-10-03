package com.zj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class MessageController {

    @Value("${server.port}")
    private String portInfo;

    @StreamListener(Sink.INPUT)
    public void getMessage(Message<String> message){
        System.out.println("消费者2号接受到的消息是："+message.getPayload()+".....port"+portInfo);
    }
}
