package com.example.demo.deadLock;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by xiatian on 2018/12/13.
 */
@Slf4j
public class DeadLock implements Runnable {

    public int flag = 1;
    private static Object o1 = new Object(), o2 = new Object();

    @Override
    public void run() {
        log.info("flat:{}", flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    log.info("get object o2");
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (o1) {
                    log.info("get object o1");
                }
            }
        }

    }

    public static void main(String[] args) {
        DeadLock d1 = new DeadLock();
        d1.flag = 1;
        DeadLock d2 = new DeadLock();
        d2.flag = 0;
        new Thread(d1).start();
        new Thread(d2).start();
    }


}