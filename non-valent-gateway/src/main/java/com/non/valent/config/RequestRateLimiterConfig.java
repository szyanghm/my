//package com.non.valent.config;
//
//import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Mono;
//
///**
// * @author haimiyang
// * @date:2019/12/26 17:52
// * @version:1.0
// */
//@Component
//public class RequestRateLimiterConfig {
//
//    /**
//     * ip地址限流
//     *
//     * @return 限流key
//     */
//    @Bean
//    @Primary
//    public KeyResolver remoteAddressKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
//    }
//
//    /**
//     * 请求路径限流
//     *
//     * @return 限流key
//     */
//    @Bean
//    public KeyResolver apiKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getPath().value());
//    }
//
//    /**
//     * username限流
//     *
//     * @return 限流key
//     */
//    @Bean
//    public KeyResolver userKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("username"));
//    }
//}
