package org.example.zzb.bootcamp.a.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class One {
    public static void main(String[] args) {
        List<String> fruits = new Vector<>();
        System.out.println(System.currentTimeMillis());
            fruits.add("apple");
            fruits.add("oranges");
            fruits.add("banana");
            fruits.add("kiwi");
            fruits.add("watermelons");
            fruits.add("mangoes");
            fruits.add("custard apples");
        System.out.println("Work done!!! Size:"+ fruits.size());
        System.out.println(System.currentTimeMillis());
    }

    private static void passTheValue(List<String> fruits) {
        List<String> myFruits = new ArrayList<>(fruits);
        System.out.println("MyFruits....");
        myFruits.forEach(System.out::println);
    }
}
