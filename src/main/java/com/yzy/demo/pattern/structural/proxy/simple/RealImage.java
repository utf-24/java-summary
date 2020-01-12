package com.yzy.demo.pattern.structural.proxy.simple;

/**
 * 真实对象，加载比较消耗资源
 * @author young
 * @date 2020/1/12 23:05
 */

public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        //从磁盘加载图片，耗时操作，通过代理延迟加载
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("display.. "+ fileName);
    }

    public void loadFromDisk(String fileName){
        System.out.println("load "+ fileName + " from disk..");
    }
}
