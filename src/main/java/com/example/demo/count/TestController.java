package com.example.demo.count;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiatian on 2018/12/11.
 */
@RestController
@Slf4j
public class TestController {
    @RequestMapping("/ok")
    @ResponseBody
    public String ok() {
        System.out.println("test project ok");
        return "ok";

    }

}
