package org.example.zzb.bootcamp.a.collections.list;

import java.util.ArrayList;
import java.util.List;

public class Subb {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("oranges");
        fruits.add("banana");
        fruits.add("kiwi");
        fruits.add("watermelons");
        fruits.add("mangoes");
        fruits.add("custard apples");
        List<String> selective = fruits.subList(1,5);
        selective.set(1,"bananaaaaaaa");
        //Now clearing the range
        selective.clear();
        System.out.println("Second one!!!!");
        fruits.forEach(System.out::println);

    }
}
