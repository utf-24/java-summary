package com.yzy.demo.pattern.structural.proxy.simple;

/**
 * 代理对象，供调用者使用
 * @author young
 * @date 2020/1/12 23:09
 */
public class ProxyImage implements Image {

    /**
     * 真实对象引用
     */
    private RealImage realImage;

    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        // 延时加载
        if(realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
