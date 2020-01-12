package com.yzy.demo.pattern.di;

/**
 * 通过构造函数注入依赖对象
 *
 * @author young
 * @date 2019/10/24 10:43
 */
public class ConstructorWizard implements Wizard {

    private AbstractTobacco tobacco;

    public ConstructorWizard(AbstractTobacco tobacco) {
        this.tobacco = tobacco;
    }

    @Override
    public void smoke() {
        System.out.println("--constructor wizard invoke smoke");
        tobacco.smoke(this);
    }
}
