package com.cloud3.sentinel.web;

import com.cloud3.commons.constants.Constants;
import com.cloud3.sentinel.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Slf4j
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping(Constants.CLOUD3 + "/hello")
    public String hello() {
        testService.doSomeThing("hello " + new Date());
        return "wenyixicodedog";
    }

    @GetMapping(Constants.CLOUD3 + "/hello2")
    public String hello2() {
        testService.doSomeThing2("hello2 " + new Date());
        return "wenyixicodedog";
    }

}