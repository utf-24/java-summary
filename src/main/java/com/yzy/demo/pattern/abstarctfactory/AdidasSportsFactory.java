package com.yzy.demo.pattern.abstarctfactory;

/**
 * @author young
 * @date 2019/7/5 9:22
 */
public class AdidasSportsFactory implements SportsFactory {
    @Override
    public Shoes createShoes() {
        return new AdidasShoes();
    }

    @Override
    public Coat createCoats() {
        return new AdidasCoat();
    }

    @Override
    public Bag creteBag() {
        return null;
    }
}
