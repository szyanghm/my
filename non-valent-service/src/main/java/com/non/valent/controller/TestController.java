package com.non.valent.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.non.valent.entity.Test;
import com.non.valent.service.impl.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haimiyang
 * @date:2019/12/19 15:43
 * @version:1.0
 */
@RestController
@Api(description = "测试API")
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping(value = "/post")
    @ApiOperation(value = "Post测试", httpMethod = "POST", response = Test.class, notes = "Post测试")
    public IPage<Test> test(@RequestBody Test test){
        return testService.selectPageVo(new Page(1,10),test.getId());
    }
}