package com.example.demo.singleton;

/**
 * Created by xiatian on 2018/12/12.
 */
//懒汉模式  双重检测机制加锁  线程也是不安全的
public class SingletonExample4 {

    //私有构造方法
    private SingletonExample4() {

    }
    //new一个对象的三个步骤
     //1、memory = allocate() 分配对象的内存空间
    //2、 ctorInstance() 初始化对象
    //3、 instance = memory 设置instance只想刚分配的内存

    //JVM和CPU优化发生指令重排

    //1、memory = allocate() 分配对象的内存空间
    //3、 instance = memory 设置instance只想刚分配的内存
    //2、 ctorInstance() 初始化对象


    //单例对象
    private static SingletonExample4 instance = null;

    public static SingletonExample4 getInstance() {
        if (instance == null) {                         //Thread B 拿到了instance但此时的instance并没有初始化
            synchronized (SingletonExample4.class) {
                if (instance == null) { //双重检测机制
                    instance = new SingletonExample4();  //Thread A  ---3
                }
            }

        }
        return instance;
    }
}
