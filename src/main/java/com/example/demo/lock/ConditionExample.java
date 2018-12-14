package com.example.demo.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xiatian on 2018/12/12.
 */
@Slf4j
public class ConditionExample {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();


        new Thread(() -> {
            try {
                reentrantLock.lock(); //线程1加入到AQS队列中
                log.info("wait signal");  // 1
                condition.await(); //线程1释放锁并加入到condition的队列中
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("get singal");     //4
            reentrantLock.unlock();

        }).start();

        new Thread(() -> {
            reentrantLock.lock(); //线程2加入到AQS队列中
            log.info("get lock");    //2
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            condition.signalAll();
            log.info("send singal ~");       //   3
            reentrantLock.unlock();

        }).start();


    }
}
