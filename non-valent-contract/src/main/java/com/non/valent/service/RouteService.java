package com.non.valent.service;

import com.non.valent.vo.ResultVO;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author haimiyang
 * @date:2019/12/26 16:14
 * @version:1.0
 */
@FeignClient(name = "non-valent-service")
@RequestMapping(value = "/route")
public interface RouteService {

    @GetMapping(value = "/get")
    ResultVO getRouteDefinitions();

    @PostMapping(value = "/save")
    ResultVO save(@RequestBody RouteDefinition routeDefinition);

    @GetMapping(value = "/delete")
    ResultVO delete(@RequestParam("routeId") String routeId);
}
