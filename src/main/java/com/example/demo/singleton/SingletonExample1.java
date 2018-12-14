package com.example.demo.singleton;

/**
 * Created by xiatian on 2018/12/12.
 */
//懒汉模式  线程不安全
public class SingletonExample1 {

    //私有构造方法
    private SingletonExample1() {

    }

    //单例对象
    private static SingletonExample1 instance = null;

    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
