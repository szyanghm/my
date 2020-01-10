package com.non.valent.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.non.valent.entity.GatewayRoute;
import com.non.valent.entity.Test;
import com.non.valent.service.impl.ElasticsearchService;
import com.non.valent.service.impl.GatewayRouteService;
import com.non.valent.service.impl.TestService;
import com.non.valent.vo.ResultVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    @Autowired
    private ElasticsearchService elasticsearchService;

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
        return ResultVO.success("111111111111111111");
    }

    @GetMapping("/init")
    public void init(){
        elasticsearchService.createIndex();
        List<Test> list =new ArrayList<>();
        list.add(new Test("123","XX0193","XX8064","0"));
        list.add(new Test("456","XX0210","XX7475","0"));
        list.add(new Test("789","XX0257","XX8097","0"));
        elasticsearchService.saveAll(list);

    }

    @GetMapping("/all")
    public Iterator<Test> all(){
        return elasticsearchService.findAll();
    }

}
