package com.xxxr.base.utils;

import org.junit.Test;

public class JWTTest {

    @Test
    public void test(){
        String token = JWTUtils.createToken(1001L, "rose");
        Long userId = JWTUtils.getUserId(token);
        System.out.println(userId);
        String username = JWTUtils.getUsername(token);
        System.out.println(username);
    }
}
