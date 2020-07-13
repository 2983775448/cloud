package com.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zengjie
 * @date 2020/4/21 20:28
 */
@Configuration
public class MyselfRule {

    @Bean
    public IRule myRule(){
        return new RandomRule(); //定义为随机
    }

}
