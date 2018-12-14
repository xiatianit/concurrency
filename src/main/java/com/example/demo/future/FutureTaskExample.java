package com.example.demo.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * Created by xiatian on 2018/12/13.
 */
@Slf4j
public class FutureTaskExample {

    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("do something in callable");
                Thread.sleep(5000);
                return "Done";
            }
        });

        new Thread(futureTask).start();
        log.info("do somethings in main");
        Thread.sleep(1000);
        String result = futureTask.get();
        log.info("result:{}", result);

    }


}
