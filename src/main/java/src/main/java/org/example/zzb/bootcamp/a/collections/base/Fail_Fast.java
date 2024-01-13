package org.example.zzb.bootcamp.a.collections.base;

import java.util.*;

public class Fail_Fast {
    public static void main(String[] args) {
        Collection<String> fruits = Collections.synchronizedList(getFruits());
        fruits.add("oranges");
        Iterator<String> iterator = fruits.iterator();

        Thread th = new Thread(() -> {
            fruits.add("mangoes"); //Throws exception: ConcurrentModificationException on both Synchronized and non Synchronized versions!!
        });
        th.start();

        while (iterator.hasNext()) {
            String fruit = iterator.next();

            // Legal way!!
//            if (fruit.equals("banana")){
//                iterator.remove();
//                continue;
//            }
            System.out.println(fruit);
        }
    }

    static ArrayList<String> getFruits() {
        return new ArrayList<>(Arrays.asList("banana", "apple", "kiwi"));
    }
}
