package com.yzy.demo.pattern.structural.proxy.simple;

/**
 * 代理测试类
 *
 * @author young
 * @date 2020/1/12 23:12
 */
public class ProxyDemo {

    public static void main(String[] args) {

         //  create proxy object
        ProxyImage image = new ProxyImage("/demo/a.png");
        // 第一次需要被加载
        image.display();
        // 现在不需要被加载
        image.display();

    }
}
