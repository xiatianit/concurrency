package com.example.demo.threadLocal;

/**
 * Created by xiatian on 2018/12/12.
 */
public class ThreadlocalHodler {

    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    public static void add(Long Id) {
        requestHolder.set(Id);
    }


    public static Long getId() {
        return requestHolder.get();
    }

    public static void remove() {
        requestHolder.remove();
    }

}
