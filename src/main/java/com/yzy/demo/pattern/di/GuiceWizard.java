package com.yzy.demo.pattern.di;

import javax.inject.Inject;

/**
 * @author young
 * @date 2019/10/24 11:00
 */
public class GuiceWizard implements Wizard {

    private AbstractTobacco tobacco;

    @Inject
    public GuiceWizard(AbstractTobacco tobacco) {
        this.tobacco = tobacco;
    }

    @Override
    public void smoke() {
        System.out.println("--guice wizard invoke smoke--");
        tobacco.smoke(this);
    }
}
