package com.example.demo.singleton;

/**
 * Created by xiatian on 2018/12/12.
 */
//懒汉模式  线程安全但是性能不好
public class SingletonExample3 {

    //私有构造方法
    private SingletonExample3() {

    }

    //单例对象
    private static SingletonExample3 instance = null;

    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
