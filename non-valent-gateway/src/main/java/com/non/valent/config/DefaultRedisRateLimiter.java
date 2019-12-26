package com.non.valent.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.gateway.filter.ratelimit.RedisRateLimiter;
import org.springframework.cloud.gateway.support.ConfigurationService;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.validation.Validator;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author haimiyang
 * @date:2019/12/26 17:54
 * @version:1.0
 */
@Configuration
public class DefaultRedisRateLimiter extends RedisRateLimiter {

    public DefaultRedisRateLimiter(ReactiveStringRedisTemplate redisTemplate, RedisScript<List<Long>> script,   @Qualifier("defaultValidator") Validator validator) {
        super(redisTemplate, script, validator);
    }

    Config getDefaultConfig() {
        return super.getConfig().get("defaultFilters");
    }

    @Override
    public Mono<Response> isAllowed(String routeId, String id) {
        if (null == super.getConfig().get(routeId))
            getConfig().put(routeId, getDefaultConfig());
        return super.isAllowed(routeId, id);
    }
}
