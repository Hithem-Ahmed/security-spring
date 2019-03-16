package com.example.demo.controller;



import com.example.demo.model.UserDO;
import com.example.demo.model.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/resource")
    public UserDO helloWorld(Authentication authentication) {
        log.info("get resource");
        UserDO user = ((UserPrincipal)authentication.getPrincipal()).getUser();
        return user;
    }

    @PostMapping("/resource1")
    public String helloUser(String userName) {
        log.info("post resource");
        return "{\"Hello\":\"" + userName +"!\"}";
    }
}
