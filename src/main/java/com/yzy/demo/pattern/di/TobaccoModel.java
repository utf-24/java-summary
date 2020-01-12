package com.yzy.demo.pattern.di;

import com.google.inject.AbstractModule;

/**
 * 使用该类绑定烟草接口和具体实现类的耦合关系
 * @author young
 * @date 2019/10/24 11:07
 */
public class TobaccoModel extends AbstractModule {

    @Override
    protected void configure() {
        bind(AbstractTobacco.class).to(ThirdTabacco.class);
    }
}
