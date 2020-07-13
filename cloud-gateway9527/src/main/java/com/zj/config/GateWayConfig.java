package com.zj.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_zj",r->r.path("/guonei").uri("http://news.baidu.com/guonei"));
        return routes.build();
    }

    @Bean
    public RouteLocator firstRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_zj",r->r.path("/guoji").uri("http://news.baidu.com/guoji"));
        return routes.build();
    }

    @Bean
    public RouteLocator secondRouteLocal(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_zj",t->t.path("/mil").uri("http://news.baidu.com/mil"));
        return routes.build();
    }

}
