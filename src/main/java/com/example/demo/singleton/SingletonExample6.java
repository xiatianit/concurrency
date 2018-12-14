package com.example.demo.singleton;

/**
 * Created by xiatian on 2018/12/12.
 */
//饿汉模式  //静态代码块初始化 线程安全
public class SingletonExample6 {

    //私有构造方法
    private SingletonExample6() {

    }

    //单例对象
    private static SingletonExample6 instance = null;

    //静态代码块
    static {
        instance = new SingletonExample6();
    }

    public static SingletonExample6 getInstance() {
        return instance;
    }
}
