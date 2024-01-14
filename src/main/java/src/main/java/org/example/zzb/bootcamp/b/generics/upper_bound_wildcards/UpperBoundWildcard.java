package org.example.zzb.bootcamp.b.generics.upper_bound_wildcards;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundWildcard {

    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        printNumbers(ints); // Will work fine!!
//        printMyList(ints); // works fine!!

        List<Double> doubles = new ArrayList<>();
        doubles.add(1.0);
        doubles.add(2.0);
        doubles.add(3.0);
//        printMyList(doubles); // won't work
        printNumbers(doubles); // Will Work

        List<String> foo = new ArrayList<>();
//        printNumbers(foo); // Won't work because the string doesn't extends numbers!!
    }

    private static void printNumbers(List<? extends  Number> numbers) {
        Number number = numbers.get(2); // generic upper bound is Number class!!
//        numbers.add(3); // Still can't add anything here
//        upper bound wildcards denies the insertion into it, just accept the retrieval of it!!
    }

    private static void printMyList(List<Integer> ints) {
    // TODO("Some Work");
    }


}
