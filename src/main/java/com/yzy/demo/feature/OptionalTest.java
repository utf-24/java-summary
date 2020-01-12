package com.yzy.demo.feature;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @author young
 * @date 2019/8/5 14:20
 */
public class OptionalTest {
    public static void main(String[] args) {
        ImInfo imInfo = null;
        Optional<ImInfo> imInfo1 = Optional.ofNullable(imInfo);
        String id = imInfo1.map(ImInfo::getId).orElse("-1");
        System.out.println(imInfo1);
        System.out.println(id);
    }
}
