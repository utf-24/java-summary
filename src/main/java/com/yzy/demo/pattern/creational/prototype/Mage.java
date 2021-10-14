package com.yzy.demo.pattern.creational.prototype;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author yangzyh
 * @date 2021/10/14 15:51
 */
@NoArgsConstructor
@EqualsAndHashCode
public abstract class Mage  implements Prototype{

    public Mage(Mage source) {
    }

    @Override
    public abstract Mage copy();
}
