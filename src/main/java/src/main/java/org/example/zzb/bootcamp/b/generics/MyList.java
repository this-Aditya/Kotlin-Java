package org.example.zzb.bootcamp.b.generics;

import java.util.ArrayList;
import java.util.List;

public class MyList {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        safelyAddToList(names, "Name 1");
        safelyAddToList(names, "Name 2");
        unsafeAddToList(names, 3);
//        String third = names.get(2); // Throws: ClassCastException
//        System.out.println(third);

        List my = new ArrayList<>();
        my.add(3);
        my.add("Hi");
    }

    static void safelyAddToList(List<String> names, String name) {
        names.add(name);
    }

    static void unsafeAddToList(List names, int name) {
        names.add(name);
    }
}
