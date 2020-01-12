package com.yzy.demo.pattern.di;

/**
 * 烟草接口
 *
 * @author young
 * @date 2019/10/24 10:23
 */
public abstract class AbstractTobacco {
    public void smoke(Wizard wizard) {
        String wizardStr = wizard.getClass().getSimpleName();
        String tobaccoStr = this.getClass().getSimpleName();
        System.out.println(wizardStr + " smoking "+ tobaccoStr);
    }
}
