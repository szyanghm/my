package com.non.valent.controller;

import com.non.valent.service.impl.RouteService;
import com.non.valent.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author haimiyang
 * @date:2019/12/26 16:15
 * @version:1.0
 */
@RestController
@RequestMapping(value = "/route")
public class RouteController {

    @Autowired
    private RouteService routeService;


    @GetMapping(value = "/get")
    public ResultVO getRouteDefinitions() {
        Collection<RouteDefinition> collection = routeService.getRouteDefinitions();
        return ResultVO.success(collection);
    }

    @PostMapping(value = "/save")
    public ResultVO save(@RequestBody RouteDefinition routeDefinition) {
        return ResultVO.success(routeService.save(routeDefinition));
    }

    @GetMapping(value = "/delete")
    public ResultVO delete(@RequestParam("routeId") String routeId) {
        return ResultVO.success(routeService.delete(routeId));
    }

}
