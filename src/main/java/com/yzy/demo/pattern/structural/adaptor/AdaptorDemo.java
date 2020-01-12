package com.yzy.demo.pattern.structural.adaptor;

/**
 * @author young
 * @date 2019/7/17 19:26
 */
public class AdaptorDemo {
    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();
        audioPlayer.play("mp3","a.mp3");
        audioPlayer.play("mp4","a.mp4");
        audioPlayer.play("vlc","a.vlc");
        audioPlayer.play("avi","a.avi");
    }
}
