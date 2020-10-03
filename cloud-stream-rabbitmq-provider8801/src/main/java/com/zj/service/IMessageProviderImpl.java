package com.zj.service;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
public class IMessageProviderImpl implements IMessageProvider{
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String randomUUid = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(randomUUid).build());
        System.out.println("randomUUid:"+randomUUid);
        return null;
    }
}
