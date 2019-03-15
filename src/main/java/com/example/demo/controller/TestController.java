package com.example.demo.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/resource")
    public String helloWorld() {
        log.info("get resource");
        return "{\"Hello\":\"World!\"}";
    }

    @PostMapping("/resource")
    public String helloUser(String userName) {
        log.info("post resource");
        return "{\"Hello\":\"" + userName +"!\"}";
    }
}
