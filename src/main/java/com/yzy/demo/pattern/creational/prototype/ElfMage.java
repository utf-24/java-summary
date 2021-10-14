package com.yzy.demo.pattern.creational.prototype;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/**
 * @author yangzyh
 * @date 2021/10/14 15:58
 */
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ElfMage extends Mage {

    private final String helpType;

    public ElfMage(ElfMage elfMage) {
        super(elfMage);
        this.helpType = elfMage.helpType;
    }

    @Override
    public ElfMage copy() {
        return new ElfMage(this);
    }

    @Override
    public String toString(){return  "eleven mage helps in " + helpType;}
}
