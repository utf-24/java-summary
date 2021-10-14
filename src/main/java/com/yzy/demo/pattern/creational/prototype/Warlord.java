package com.yzy.demo.pattern.creational.prototype;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author yangzyh
 * @date 2021/10/14 15:52
 */
@NoArgsConstructor
@EqualsAndHashCode
public abstract class Warlord implements Prototype{

    public Warlord(Warlord source) {
    }

    @Override
    public abstract Warlord copy();
}
