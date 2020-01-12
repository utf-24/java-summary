package com.yzy.demo.pattern.structural.adaptor;

/**
 * @author young
 * @date 2019/7/17 19:11
 */
public class AdvanceMediaAdaptor implements MediaPlayer {
    /**
     * 使用适配对象(mp4播放器)来辅助适配操作
     */
    AdvancedMediaPlayer advancedMediaPlayer;
    /**
     * 根据音频类型实例化辅助对象（advancedMediaPlayer）
     * @param audioType
     */
    public AdvanceMediaAdaptor(String audioType){
        if(audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer = new VlcPlayer();
        } else if (audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer = new Mp4Player();
        }
    }
    @Override
    public void play(String audioType, String filename) {
        // 实现被适配对象依赖的接口
        if(audioType.equalsIgnoreCase("mp4")){
            advancedMediaPlayer.playMp4(filename);
        } else if (audioType.equalsIgnoreCase("vlc")){
            advancedMediaPlayer.playVlc(filename);
        }
    }
}
