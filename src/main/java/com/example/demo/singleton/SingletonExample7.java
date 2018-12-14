package com.example.demo.singleton;

/**
 * Created by xiatian on 2018/12/12.
 */
//懒汉模式  //静态内部类实现 线程安全且懒加载
public class SingletonExample7 {

    //私有构造方法
    private SingletonExample7() {

    }


    public static SingletonExample7 getInstance() {
        return Singleton.instatnce;
    }


    private static class Singleton {
        private static final SingletonExample7 instatnce = new SingletonExample7();
    }

}
