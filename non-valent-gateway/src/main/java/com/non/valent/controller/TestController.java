//package com.non.valent.controller;
//
//import com.non.valent.entity.GatewayRoute;
//import com.non.valent.vo.ResultVO;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author haimiyang
// * @date:2019/12/19 15:43
// * @version:1.0
// */
//@RestController
//@RequestMapping(value = "/test")
//@Api(description = "测试swagger接口")
//public class TestController {
//
//
//
//    @GetMapping(value = "/get")
//    @ApiOperation(value = "Get测试", httpMethod = "GET", response = GatewayRoute.class, notes = "Get测试")
//    public ResultVO get(@RequestParam("id") String id) {
//        return ResultVO.success("1111111111111");
//    }
//}
