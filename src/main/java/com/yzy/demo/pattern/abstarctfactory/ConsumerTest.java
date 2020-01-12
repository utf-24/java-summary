package com.yzy.demo.pattern.abstarctfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author young
 * @date 2019/7/5 9:23
 */
public class ConsumerTest {

    private Shoes shoes;
    private Coat coat;
    private Bag bag;
    /**
     *   create factory
     */
    public void createSports(final SportsFactory factory){
        setCoat(factory.createCoats());
        setShoes(factory.createShoes());
        setBag(factory.creteBag());
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }

    public Shoes getShoes() {
        return shoes;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }

    public Coat getCoat() {
        return coat;
    }

    public void setCoat(Coat coat) {
        this.coat = coat;
    }

    /**
     * the factory of SportsFactory
     */
    public static class FactoryMaker{
        public enum SportsType {
            NIKE,ADIDAS
        }

        public static SportsFactory makeFactory(SportsType type){
            switch (type){
                case NIKE:
                    return new NikeSportsFactory();
                case ADIDAS:
                    return new AdidasSportsFactory();
                    default:
                        throw new IllegalArgumentException("sports type not supported!");
            }
        }

    }

    public static void main(String[] args) {
        ConsumerTest consumer = new ConsumerTest();
        System.out.println("buy nike:");
        consumer.createSports(FactoryMaker.makeFactory(FactoryMaker.SportsType.NIKE));
        System.out.println(consumer.getCoat().getDescription());
        System.out.println(consumer.getShoes().getDescription());
        System.out.println(consumer.getBag().getDescription());

        System.out.println("buy adidas:");
        consumer.createSports(FactoryMaker.makeFactory(FactoryMaker.SportsType.ADIDAS));
        System.out.println(consumer.getShoes().getDescription());
        System.out.println(consumer.getCoat().getDescription());
//        System.out.println(consumer.getBag().getDescription());
    }
}
