package com.yzy.demo.pattern.di;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 *
 * 测试di
 *
 * @author young
 * @date 2019/10/24 10:21
 */
public class App {
    public static void main(String[] args) {
        // 1.直接依赖，违反IOC原则
        SimpleWizard simpleWizard = new SimpleWizard();
        simpleWizard.smoke();
        // 2.通过构造函数注入依赖
        ConstructorWizard constructorWizard = new ConstructorWizard(new SecondTabacco());
        constructorWizard.smoke();
        // 3.通过setter函数注入依赖
        SetterWizard setterWizard = new SetterWizard();
        setterWizard.setTobacco(new SecondTabacco());
        setterWizard.smoke();
        // 4.通过guice注入依赖
        Injector injector = Guice.createInjector(new TobaccoModel());
        GuiceWizard guiceWizard = injector.getInstance(GuiceWizard.class);
        guiceWizard.smoke();
    }
}
