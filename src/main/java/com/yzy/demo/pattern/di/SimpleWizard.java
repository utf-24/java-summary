package com.yzy.demo.pattern.di;

/**
 * 通过直接创建依赖类的实例进行注入，强耦合
 *
 * @author young
 * @date 2019/10/24 10:39
 */
public class SimpleWizard implements Wizard {

    private AbstractTobacco tobacco = new FirstTabacco();

    @Override
    public void smoke() {
        System.out.println("--simple wizard invoke smoke--");
        tobacco.smoke(this);
    }
}
