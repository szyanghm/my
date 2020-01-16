package com.non.valent.controller;

import com.non.valent.service.impl.AuthService;
import com.non.valent.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author haimiyang
 * @date:2020/1/16 16:47
 * @version:1.0
 */
@RestController
@RequestMapping(value = "/oauth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping(value = "/getToken")
    public ResultVO getJwt(@RequestParam(value = "token") String token){
        return ResultVO.success(authService.getJwt(token));
    }
}
