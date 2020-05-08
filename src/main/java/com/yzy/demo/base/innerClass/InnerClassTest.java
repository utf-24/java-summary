package com.yzy.demo.base.innerClass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

/**
 * @author yangzyh
 * @date 2020/4/29 20:04
 */
public class InnerClassTest {
    public static void main(String[] args) {
        var clock = new TalkingClock2(1000, true);
        clock.start();

        JOptionPane.showMessageDialog(null, "Quit Progarm?");
        System.exit(0);
    }
}
// 普通内部类
 class TalkingClock2 {
    private int interval;
    private boolean beep;

    public  TalkingClock2(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        var listener = new TimePrinter();
        var timer = new Timer(interval, listener);
        timer.start();
    }


    public class TimePrinter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("At the tone, the time is " + Instant.ofEpochMilli(e.getWhen()));
            if (beep) Toolkit.getDefaultToolkit().beep();
        }
    }
}