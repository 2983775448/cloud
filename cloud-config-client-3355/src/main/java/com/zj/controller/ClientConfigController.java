package com.zj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ClientConfigController {

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/getConfigInfo")
    private String getConfigInfo(){
        return configInfo;
    }

}
