package org.example.zzb.bootcamp.a.collections.sets;

import java.util.HashSet;
import java.util.Set;

public class Base {
    public static void main(String[] args) {
        Set<String> mySet = new HashSet<>();
        mySet.add("apples");
        mySet.add("banana");
        mySet.add("oranges");
        mySet.add("apples");
        mySet.add("bananas");
        mySet.forEach(System.out::println);
    }
}
