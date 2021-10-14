package com.yzy.demo.pattern.creational.prototype;

import lombok.RequiredArgsConstructor;

/**
 * @author yangzyh
 * @date 2021/10/14 16:07
 */
@RequiredArgsConstructor
public class HeroFactoryImpl implements HeroFactory {

    private final Mage mage;
    private final Warlord warlord;
    private final Beast beast;

    @Override
    public Mage createMage() {
        return mage.copy();
    }

    @Override
    public Warlord createWarlord() {
        return warlord.copy();
    }

    @Override
    public Beast createBeast() {
        return beast.copy();
    }
}
