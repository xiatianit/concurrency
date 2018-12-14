package com.example.demo.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiatian on 2018/12/13.
 */
@Slf4j
public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService exec = Executors.newScheduledThreadPool(5);
        exec.schedule(new Runnable() {
            @Override
            public void run() {
                log.info("ScheduledThreadPool do somethings");
            }
        }, 3, TimeUnit.SECONDS);
        exec.shutdown();
    }
}
