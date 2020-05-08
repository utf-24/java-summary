package com.yzy.demo.base.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * @author yangzyh
 * @date 2020/4/29 19:23
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        var clock = new TalkingClock();
        clock.start(1000, true);

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
class TalkingClock {
    public void start(int interval, boolean beep) {
        // 匿名内部类
        var listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("At the tone, the time " + Instant.ofEpochMilli(e.getWhen()));
                if(beep) Toolkit.getDefaultToolkit().beep();

            }
        };

        var timer = new Timer(interval, listener);
        timer.start();
    }
}