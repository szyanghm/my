package com.non.valent.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.non.valent.entity.Test;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author haimiyang
 * @date:2019/12/19 17:11
 * @version:1.0
 */
@FeignClient(name = "service-producer")
@RequestMapping(value = "/test")
public interface TestService {

    @PostMapping(value = "/post")
    IPage<Test> selectPageVo(@RequestBody Test test);
}
