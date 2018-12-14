package com.example.demo.singleton;

/**
 * Created by xiatian on 2018/12/12.
 */
//私有枚举类实现，线程安全且在调用的时候初始化不会浪费资源
public class SingletonExample8 {

    //私有构造方法
    private SingletonExample8() {

    }


    public static SingletonExample8 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }


    private enum Singleton {
        INSTANCE;
        private SingletonExample8 instance;

        //JVM保证这个构造方法绝对只调用一次
        Singleton() {
            instance = new SingletonExample8();
        }

        private SingletonExample8 getInstance() {
            return instance;
        }
    }

}
