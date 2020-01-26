package com.yzy.demo.jvm.ref;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
  * @author young
 * @date 2020/1/25 23:26
 */
public class WeakHashMapTest {

    public static void main(String[] args) {
        House seller1 = new House("seller no.1");
        House seller2 = new House("seller no.2");
        SellerInfo sellerInfo1 = new SellerInfo();
        SellerInfo sellerInfo2 = new SellerInfo();

        WeakHashMap<House, SellerInfo> weakHashMap
                = new WeakHashMap<House, SellerInfo>();
        //如果是hashmap，size还是2，是强应用
//        HashMap weakHashMap = new HashMap();
        weakHashMap.put(seller1, sellerInfo1);
        weakHashMap.put(seller2, sellerInfo2);

        System.out.println("weakHashMap before null, size: " + weakHashMap.size());

        seller1 = null;
        System.gc();
        System.runFinalization();

        System.out.println("weakHashMap after null, size: " + weakHashMap.size());
        System.out.println(weakHashMap);

    }

    static class House {
        String name;

        public House(String name) {
            this.name = name;
        }
    }

    static class SellerInfo {

    }
}