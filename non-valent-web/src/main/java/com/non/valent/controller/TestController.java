package com.non.valent.controller;

import com.non.valent.entity.Test;
import com.non.valent.service.TestService;
import com.non.valent.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author haimiyang
 * @date:2019/12/20 16:04
 * @version:1.0
 */
@RestController
@Api(description = "测试API")
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping(value = "/v1/post")
    @ApiOperation(value = "Post测试", httpMethod = "POST", response = Test.class, notes = "Post测试")
    public ResultVO test(@RequestBody Test test){
        return testService.selectPageVo(test);
    }

    @PostMapping(value = "/v1/fileUpload",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ApiOperation(value = "Post测试", httpMethod = "POST", response = MultipartFile.class, notes = "Post测试")
    public ResultVO fileUpload(@RequestPart("file") MultipartFile file) {
        ResultVO resultVO = testService.fileUpload(file);
        return resultVO;
    }
}
