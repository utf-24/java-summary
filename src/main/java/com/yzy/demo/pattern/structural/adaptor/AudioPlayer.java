package com.yzy.demo.pattern.structural.adaptor;

/**
 * @author young
 * @date 2019/7/17 19:07
 */
public class AudioPlayer implements MediaPlayer {

    private AdvanceMediaAdaptor adaptor;

    @Override
    public void play(String audioType, String filename) {
        if(audioType.equalsIgnoreCase("mp3")){
            // 内置功能
            System.out.println("play mp3");
        } else if(audioType.equalsIgnoreCase("mp4") ||
            audioType.equalsIgnoreCase("vlc")){
            // 适配器转换操作
            adaptor = new AdvanceMediaAdaptor(audioType);
            adaptor.play(audioType,filename);
        } else {
            System.out.println("invalid audio type");
        }
    }
}
