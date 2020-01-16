package com.non.valent.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * @author haimiyang
 * @date:2019/12/19 15:43
 * @version:1.0
 */
public class TestController {


    public static void main(String[] args) {
        Claims claims = Jwts.parser()
                .setSigningKey("123456".getBytes()).parseClaimsJws("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1NzkxNjAxNTcsInVzZXJfbmFtZSI6InVzZXIiLCJhdXRob3JpdGllcyI6WyJ0ZXN0Il0sImp0aSI6IjZjY2NiNjM4LWNjOTQtNDM4OC1iMTEzLTFhYjM1MTk2NGZkZSIsImNsaWVudF9pZCI6InRlc3QiLCJzY29wZSI6WyJhbGwiLCJhIiwiYiIsImMiXX0.FXW1QtcgysPc8nDaleVPTaTSTTqgPhgigee7fl-YTD0")
                .getBody();
    }
}
