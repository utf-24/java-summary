package com.yzy.demo.pattern.structural.adaptor;

/**
 * @author young
 * @date 2019/7/17 19:08
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String filename) {
        System.out.println("vlcPlayer play "+ filename);
    }

    @Override
    public void playMp4(String filename) {
        System.out.println("vlcPlayer do noting");
    }
}
