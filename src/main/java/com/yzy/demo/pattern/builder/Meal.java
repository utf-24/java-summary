package com.yzy.demo.pattern.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author young
 * @date 2019/8/8 20:49
 */
public class Meal {
    public List<Item> getItems() {
        if(items == null) {
            return null;
        } else {
            return Collections.unmodifiableList(items);
        }
    }

    public void setItems(List<Item> items) {
        if(items == null) {
            this.items = null;
        }else{
            this.items = Collections.unmodifiableList(items);
        }
    }

    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public float getPrice() {
        float price = 0.f;
        for (Item item : items) {
            price += item.getPrice();
        }
        return price;
    }

    public void showItems() {
        for (Item item : items) {
            System.out.println("item: " + item.getName());
            System.out.println("price: " + item.getPrice());
            System.out.println("packing: " + item.getPacking());
        }
    }

}
