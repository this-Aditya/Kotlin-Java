package org.example.zzb.bootcamp.a.collections.base;

import java.util.*;

public class Fail_Fast {
    public static void main(String[] args) {
        Collection<String> fruits = getFruits();
        fruits.add("oranges");
        Iterator<String> iterator = fruits.iterator();


//        fruits.add("mangoes"); Throws exception: ConcurrentModificationException


        while (iterator.hasNext()) {
            String fruit = iterator.next();

            // Legal way!!
            if (fruit.equals("banana")){
                iterator.remove();
                continue;
            }
            System.out.println(fruit);
        }
    }

    static Collection<String> getFruits() {
        return new ArrayList<>(Arrays.asList("banana", "apple", "kiwi"));
    }
}
