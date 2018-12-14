package com.example.demo.threadLocal;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by xiatian on 2018/12/12.
 */
@Slf4j
@RestController
@RequestMapping("/threadLocal")
public class TestThreadLocalController {

    @RequestMapping("/test")
    public void test() {
        log.info("test");
    }
}
