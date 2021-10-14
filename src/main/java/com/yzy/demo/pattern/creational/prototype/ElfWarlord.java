package com.yzy.demo.pattern.creational.prototype;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author yangzyh
 * @date 2021/10/14 16:03
 */
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ElfWarlord extends Warlord {

    private final String helpType;

    public ElfWarlord(ElfWarlord source) {
        super(source);
        this.helpType = source.helpType;
    }

    @Override
    public ElfWarlord copy() {
        return new ElfWarlord(this);
    }

    @Override
    public String toString() {
        return "elven warlord helps in " + helpType;
    }
}
