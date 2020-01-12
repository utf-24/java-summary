package com.yzy.demo.util;

import ch.qos.logback.core.util.TimeUtil;
import com.google.common.hash.Hashing;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author young
 * @date 2019/5/21 19:25
 */
public class SleepUtils {
    public static final void second(long seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
        }
    }

    public static final void millSeconds(long millSeconds) {
        try {
            TimeUnit.MILLISECONDS.sleep(millSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>(8);
        map.put("a","b");
        System.out.println(map);
    }
}
