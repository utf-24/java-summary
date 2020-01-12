package com.yzy.demo.pattern.abstarctfactory;

/**
 * @author young
 * @date 2019/7/5 9:21
 */
public class NikeSportsFactory implements SportsFactory {
    @Override
    public Shoes createShoes() {
        return new NikeShoes();
    }

    @Override
    public Coat createCoats() {

        return new NikeCoat();
    }

    @Override
    public Bag creteBag() {
        return new NikeBag();
    }
}
