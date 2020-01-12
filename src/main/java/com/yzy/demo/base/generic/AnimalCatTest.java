package com.yzy.demo.base.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author young
 * @date 2019/10/22 8:49
 */
public class AnimalCatTest {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        List<Cat> cats = new ArrayList<>();
        List<TomCat> tomCats = new ArrayList<>();

        animals.add(new Animal());
        cats.add(new Cat());
        tomCats.add(new TomCat());

        //测试赋值操作
//        List<? extends Cat> extendsCatFromAnimal = animals;
        List<? super Cat> superCatFromAnimal = animals;

        List<? extends Cat> extendsCatFromCat = cats;
        List<? super Cat> superCatFromCat = animals;

        List<? extends Cat> extendsCatFromTom = tomCats;
//        List<? super Cat> superCatFromTom = tomCats;

        // 测试add方法
//        extendsCatFromCat.add(new Animal());
//        extendsCatFromCat.add(new Cat());
//        extendsCatFromCat.add(new TomCat());
//        superCatFromCat.add(new Animal());
        superCatFromCat.add(new Cat());
        superCatFromCat.add(new TomCat());

        // 测试get方法
        Object catExtends1 = extendsCatFromCat.get(0);
        Cat catExtends2 = extendsCatFromCat.get(1);

//        TomCat tomCat = extendsCatFromTom.get(0);
        Object cat = superCatFromCat.get(0);

    }
}
