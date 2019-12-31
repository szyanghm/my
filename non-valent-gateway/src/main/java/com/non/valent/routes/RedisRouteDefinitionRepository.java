package com.non.valent.routes;

import com.non.valent.service.impl.RouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * @author haimiyang
 * @date:2019/12/26 16:12
 * @version:1.0
 */
@Component
@Slf4j
public class RedisRouteDefinitionRepository implements RouteDefinitionRepository {

    @Autowired
    private RouteService routeService;

    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        Collection<RouteDefinition> collection = routeService.getRouteDefinitions();
        return Flux.fromIterable(collection);
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return route.flatMap(routeDefinition -> {
            routeService.save(routeDefinition);
            return Mono.empty();
        });
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return routeId.flatMap(id -> {
            routeService.delete(id);
            return Mono.empty();
        });
    }
}
