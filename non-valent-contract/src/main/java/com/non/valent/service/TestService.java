package com.non.valent.service;

import com.non.valent.entity.Test;
import com.non.valent.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author haimiyang
 * @date:2019/12/19 17:11
 * @version:1.0
 */
@FeignClient(name = "non-valent-service")
@RequestMapping(value = "/test")
public interface TestService {

    @PostMapping(value = "/post")
    ResultVO selectPageVo(@RequestBody Test test);

    @PostMapping(value = "/fileUpload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ResultVO fileUpload(@RequestPart("file") MultipartFile file);
}
