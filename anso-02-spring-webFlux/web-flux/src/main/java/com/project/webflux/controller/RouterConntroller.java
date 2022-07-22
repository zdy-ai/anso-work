package com.project.webflux.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

/**
 * @Package: com.example.springbootwebFlux.controller
 * @Description： TODO
 * @Author: zdy AX1053
 * @Date: Created in 2022/7/6 9:33
 * @Company: ANSO
 * @Copyright: Copyright (c) 2021
 * @Version: 1.2.0
 * @Modified By:
 */
@Component
public class RouterConntroller {
    /**
     * 函数编程
     */
    @Bean
    public RouterFunction<ServerResponse> routers(){
        return RouterFunctions.route().GET("/func/greeting", new HandlerFunction<ServerResponse>() {
            @Override
            public Mono<ServerResponse> handle(ServerRequest request) {
                return ServerResponse.ok().bodyValue("hello webflux by function");
            }
        }).build();
    }
}
