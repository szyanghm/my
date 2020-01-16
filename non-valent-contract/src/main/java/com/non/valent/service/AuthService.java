package com.non.valent.service;

import com.non.valent.vo.ResultVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author haimiyang
 * @date:2020/1/16 16:46
 * @version:1.0
 */
@FeignClient(name = "non-valent-service")
@RequestMapping(value = "/oauth")
public interface AuthService {

    @GetMapping(value = "/getToken")
    ResultVO getJwt(@RequestParam("token") String token);
}
