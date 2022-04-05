package com.luobo.controller;

import com.luobo.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demo")
public class ModuleRedisController {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/set.json")
    public void set_demo(){
        String ret = redisUtil.setex("zhuzhu", 600, "mimi");
        System.out.println(ret);
    }

    @GetMapping("/get.json")
    public void get_demo(){
    }
}
