package com.yzy.demo.pattern.creational.singleton;

/**
 * 双重锁定检测
 * @author yangzyh
 * @date 2021/4/21 21:26
 */
public class DoubleCheckSingleTon {

    private static volatile DoubleCheckSingleTon instance;

    private DoubleCheckSingleTon() {
        if(instance == null) {
            instance = this;
        } else  {
            // 防止反射生成多个实例
            throw new IllegalStateException("instance already initialized.");
        }
    }

    public DoubleCheckSingleTon getSingleTon() {
        if (instance == null) {
            synchronized (DoubleCheckSingleTon.class) {
                if(instance == null) {
                    instance = new DoubleCheckSingleTon();
                }
            }
        }

        return instance;
    }

    public static void main(String[] args) {
        SingletTon.getInstance();
    }
}
