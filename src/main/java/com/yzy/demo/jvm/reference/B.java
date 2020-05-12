package com.yzy.demo.jvm.reference;

import lombok.Data;

/**
 * @author young
 * @date 2019/8/13 10:42
 */
@Data
public class B {
    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }

    private String bName;
}
