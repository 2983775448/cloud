package com.zj.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SentinelController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/test1")
    public String test1(){
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        int i = 10 / 0;
        return "test1......port:"+serverPort;
    }

    @GetMapping("/test2")
    public String test2(){
        return "test2....port:"+serverPort;
    }

    @GetMapping("/hotSpot")
    @SentinelResource(value = "hotSpot",blockHandler = "hotSpotHandler")
    public String testHotSpot(@RequestParam(value = "q1",required = false) String q1,
                              @RequestParam(value = "q2",required = false) String q2){
        return "testHotSpot.......";
    }

    public String hotSpotHandler(String p1, String p2, BlockException exception){
        return "hotSpotHandler.......";
    }
}
