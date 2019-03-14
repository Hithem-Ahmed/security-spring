package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final Logger log = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/resource")
    public String home(){

        log.info("resource");
        return "{\"Hello\":\"World!\"}";
    }
}
