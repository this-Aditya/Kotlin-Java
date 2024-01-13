package org.example.zzb.bootcamp.a.collections.sets;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetExample {
    public static void main(String[] args) {
        SortedSet<String> vocab = new TreeSet<>();
        vocab.add("mango");
        vocab.add("apple");
        vocab.add("pineapple");
        vocab.add("banana");
        vocab.add("strawberry");
        vocab.add("kiwi");


        String first = vocab.first();
        String last = vocab.last();

        System.out.println("vocab = " + vocab);
        System.out.println("first = " + first);
        System.out.println("last = " + last);

        System.out.println(vocab.headSet("mango"));
        System.out.println(vocab.tailSet("mango"));

        System.out.println(vocab.subSet("banana", "pineapple"));
    }
}
