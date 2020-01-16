package com.non.valent.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author haimiyang
 * @date:2020/1/16 10:18
 * @version:1.0
 */
@RestController
public class UserController {

    @Resource
    private AuthorizationServerTokenServices authorizationServerTokenServices;

    @GetMapping("index")
    public Object index(@AuthenticationPrincipal Authentication authentication){
        //OAuth2AccessToken token = authorizationServerTokenServices.getAccessToken(authentication);
        return authentication;
    }

}
