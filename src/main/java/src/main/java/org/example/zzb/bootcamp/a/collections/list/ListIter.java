package org.example.zzb.bootcamp.a.collections.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIter {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("mangoes");
        fruits.add("apples");
        fruits.add("bananas");
        fruits.add("oranges");
        fruits.add("watermelons");
        fruits.add("strawberries");
        fruits.add("mangoes");
        fruits.add("watermelons");
        for(ListIterator<String> li = fruits.listIterator(); li.hasNext(); ) {
            String current = li.next();
            if (current.equals("watermelons")||current.equals("mangoes")) {
                li.set("favourites");
            }
        }
        fruits.forEach(System.out::println);
    }
}
