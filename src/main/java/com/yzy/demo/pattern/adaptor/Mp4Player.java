package com.yzy.demo.pattern.adaptor;

/**
 * @author young
 * @date 2019/7/17 19:09
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String filename) {
        System.out.println("mp4 do nothing");
    }

    @Override
    public void playMp4(String filename) {
        System.out.println("mp4 play "+filename);
    }
}
