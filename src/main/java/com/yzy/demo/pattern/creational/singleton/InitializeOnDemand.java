package com.yzy.demo.pattern.creational.singleton;

/**
 * 按需初始化, 加载外部类时不会立刻初始化内部类，只有第一次调用getInstance()时
 * 才会初始化INSTANCE, jvm保证了这个过程的线程安全
 * @author yangzyh
 * @date 2021/10/29 21:13
 */
public class InitializeOnDemand {

    private static class InitializeOnDemandHolder{
        private static InitializeOnDemand INSTANCE = new InitializeOnDemand();
    }

    public static InitializeOnDemand getInstance() {
        return InitializeOnDemandHolder.INSTANCE;
    }
}
