package com.yzy.demo.pattern.creational.prototype;

/**
 * abstract factory
 * @author yangzyh
 * @date 2021/10/14 16:06
 */
public interface HeroFactory {

    Mage createMage();

    Warlord createWarlord();

    Beast createBeast();
}
