package com.luobo.controller;

import com.luobo.mq.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/module_1")
public class ModuleController {
    @Autowired
    private MsgProducer msgProducer;

    @GetMapping("/hello.json")
    public void hello(){
        System.out.println("hello");
    }

    @GetMapping("/send.json")
    public void send(){
        String content="mq_demo";
        msgProducer.sendMsg(content);
    }
}
