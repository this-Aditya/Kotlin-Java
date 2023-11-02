package org.example.b.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AWildcard {
    public static void main(String[] args) {
        List<Integer> one = Arrays.asList(1,2,3,4,5);
        System.out.println("Sum "+ sumOfList(one));

    }

    public static double sumOfList(List<? extends Number> nums) {
        double sum = 0.0;
        for (Number num: nums) {
            sum += num.doubleValue();
        }
        return sum;
    }
}


class UnBounded {

    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<Integer>();
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
//        printList(intList); // Error: Required List<Object>, Found List<Integer?
// List<? extends Object> == List<?>
        printListTwo(intList);
        System.out.println();
        System.out.println();
        List<Integer> doubleList = new LinkedList<Integer>();
        doubleList.add(5);
        doubleList.add(6);
        doubleList.add(7);
        doubleList.add(8);
        printListTwo(doubleList);

        List<Object> objectList = new ArrayList<>();
        objectList.add("String");
        objectList.add(10);
        objectList.add(21374L);
        objectList.add(213.8);
        printList(objectList);

        List<?> lastList = new ArrayList<>();
//        lastList.add("hello");
//        lastList.add(5);
        lastList.add(null);
    }

    public static void printList(List<Object> elem) {
        for (Object obj: elem) {
            System.out.println(obj + " ");
        }
    }

    public static void printListTwo(List<?> elem) {
        for (Object obj: elem) {
            System.out.println(obj+" ");
        }
    }

}
