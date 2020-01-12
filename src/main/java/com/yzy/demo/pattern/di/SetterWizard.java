package com.yzy.demo.pattern.di;

/**
 * 通过setter方法注入依赖对象
 *
 * @author young
 * @date 2019/10/24 10:47
 */
public class SetterWizard implements Wizard {

    private AbstractTobacco tobacco;

    public void setTobacco(AbstractTobacco tobacco) {
        this.tobacco = tobacco;
    }

    @Override
    public void smoke() {
        System.out.println("--setter wizard invoke tobacco");
        tobacco.smoke(this);
    }
}
