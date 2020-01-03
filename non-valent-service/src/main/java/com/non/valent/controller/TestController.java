package com.non.valent.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.non.valent.entity.GatewayRoute;
import com.non.valent.entity.Test;
import com.non.valent.service.impl.GatewayRouteService;
import com.non.valent.service.impl.TestService;
import com.non.valent.utils.FileUtils;
import com.non.valent.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author haimiyang
 * @date:2019/12/19 15:43
 * @version:1.0
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private GatewayRouteService gatewayRouteService;

    @PostMapping(value = "/post")
    @ApiOperation(value = "Post测试", httpMethod = "POST", response = Test.class, notes = "Post测试")
    public ResultVO test(@RequestBody Test test){
        IPage<Test> page = testService.selectPageVo(new Page(1,10),test.getId());
        return ResultVO.success(page);
    }

    @GetMapping(value = "/query/route")
    @ApiOperation(value = "Get测试", httpMethod = "GET", response = GatewayRoute.class, notes = "Get测试")
    public ResultVO get(@RequestParam("id") String id) {
        GatewayRoute gatewayRoute = gatewayRouteService.get(id);
        return ResultVO.success(gatewayRoute);
    }

    @GetMapping(value = "/overload")
    @ApiOperation(value = "Get测试", httpMethod = "GET",  notes = "Get测试")
    public ResultVO overload() {
        return ResultVO.success(gatewayRouteService.overload());
    }

    @PostMapping(value = "/fileUpload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "Post测试", httpMethod = "POST", response = Test.class, notes = "Post测试")
    public ResultVO fileUpload(@RequestPart("file") MultipartFile file){
        File f = FileUtils.multipartFileToFile(file);
        return ResultVO.success("111111111111111111");
    }
}
