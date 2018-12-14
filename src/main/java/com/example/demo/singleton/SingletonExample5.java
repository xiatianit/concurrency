package com.example.demo.singleton;

/**
 * Created by xiatian on 2018/12/12.
 */
//懒汉模式  双重检测机制加锁  线程安全的  加了volatile禁止指令重排序
public class SingletonExample5 {

    //私有构造方法
    private SingletonExample5() {

    }
    //new一个对象的三个步骤
     //1、memory = allocate() 分配对象的内存空间
    //2、 ctorInstance() 初始化对象
    //3、 instance = memory 设置instance只想刚分配的内存

    //JVM和CPU优化发生指令重排

    //1、memory = allocate() 分配对象的内存空间
    //3、 instance = memory 设置instance只想刚分配的内存
    //2、 ctorInstance() 初始化对象


    //单例对象  volatile+双重检测机制
    private volatile static SingletonExample5 instance = null;

    public static SingletonExample5 getInstance() {
        if (instance == null) {
            synchronized (SingletonExample5.class) {
                if (instance == null) { //双重检测机制
                    instance = new SingletonExample5();
                }
            }

        }
        return instance;
    }
}
