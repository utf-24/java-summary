package com.yzy.demo.reference;

import lombok.Data;

/**
 * @author young
 * @date 2019/8/13 10:42
 */
@Data
public class A {
    private String aName;

    private B b;

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        B b1 = new B();
        b1.setbName(b.getbName());
        this.b = b1;
    }
}
