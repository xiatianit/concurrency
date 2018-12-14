package com.example.demo.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiatian on 2018/12/13.
 */
@Slf4j
public class CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
             final  int index = i;
            exec.execute(() -> {
                log.info("task:{}", index);
                doSomeThing(index);
            });
        }
        exec.shutdown();
    }

    public static void doSomeThing(Integer index) {
        try {
            log.info("do someThings in {} thread",index);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
