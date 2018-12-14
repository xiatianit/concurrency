package com.example.demo.singleton;

/**
 * Created by xiatian on 2018/12/12.
 */
//饿汉模式 实例在类装载的时候就创建了    线程安全但浪费资源
public class SingletonExample2 {

    //私有构造方法
    private SingletonExample2() {

    }

    //单例对象静态域初始化
    private static SingletonExample2 instance = new SingletonExample2();

    public static SingletonExample2 getInstance() {
            return instance;
        }
    }
