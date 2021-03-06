package com.example.demo.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiatian on 2018/12/12.
 */
@Slf4j
public class CyclicBarrierExample2 {


    private static CyclicBarrier barrier = new CyclicBarrier(5,()->{
        log.info("callback is ready");
    }
    );

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int threadNum = i;
            Thread.sleep(1000);
            exec.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("exception", e);
                    e.printStackTrace();
                }
            });
        }
        exec.shutdown();
    }


    private static void race(int threadNum) throws Exception {
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        barrier.await();
        log.info("{} continue", threadNum);


    }

}
