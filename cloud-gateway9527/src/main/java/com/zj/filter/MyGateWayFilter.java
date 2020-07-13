package com.zj.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class MyGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if (uname == null){
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            log.info("##########    uanme不存在  ##################");
            return exchange.getResponse().setComplete();
        }
        log.info("########## uname存在  ###########");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
