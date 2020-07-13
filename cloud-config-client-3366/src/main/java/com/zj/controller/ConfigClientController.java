package com.zj.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Scope(scopeName = "refresh")
public class ConfigClientController {

    @Value("${config.info}")
    private String configInfo;

    @RequestMapping("/configInfo")
    private String getConfigInfo(){
        return configInfo;
    }
}
