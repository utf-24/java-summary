package com.yzy.demo.pattern.creational.prototype;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author yangzyh
 * @date 2021/10/14 15:48
 */
@EqualsAndHashCode
@NoArgsConstructor
public abstract class Beast implements Prototype{
    public Beast(Beast source) {
    }

    @Override
    public abstract Beast copy();
}
