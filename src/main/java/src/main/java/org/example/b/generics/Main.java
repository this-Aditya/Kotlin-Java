package org.example.b.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    Box<String> box = new Box<>();
    OrderedPair<String, Integer> op1 = new OrderedPair<String, Integer>("Token-Type", 1);
    OrderedPair<String, String> op2 = new OrderedPair<String, String>("Server", "Nginx");
    OrderedPair<String, Box<String>> o3 = new OrderedPair<>("Box-Type", new Box<>());

    // For backward compatibility, assigning the parameterized type to its raw type is allowed:
    Box<String> stringBox = new Box<>();
    Box rawBox = stringBox;

    static OrderedPair<String, Integer> o1 = new OrderedPair<>("Apple", 1);
    static OrderedPair<String, Integer> o2 = new OrderedPair<>("Banana", 2);
    static OrderedPair<String, Integer> o11 = new OrderedPair<>("Apple", 1);

    //But we can't assign the rawType to a parameterized type:
//    Box rawType = new Box();
//    Box<String> paramType = rawType;  Warning: Unchecked assignment



    public static void main(String[] args) {
//        System.out.println("Comparison between OP1 and OP11: Are the Same? "+ Util.compare(o1, o11));
//        System.out.println("Is o1 and o2 same? "+ Util.compare(o1, o2));

//        Box<String> stringB = new Box<>();
//        stringB.set("Some text");
//      stringB.inspect(new Boolean(true)); Required U provided Boolean
//        stringB.inspect("Hello World");

        ArrayCompareGenerics arrGen = new ArrayCompareGenerics();
        // Using Integer[], not int[] coz int doesn't implements Comparable, as Integer does.
//        int[] intArr1 = {1,2,3,4,5,6,7,8,9,10};
        Integer[] intArr = {1,2,3,4,5,6,7,8,9,10};
//        arrGen.countGreaterThan(intArr1, 5);
        int num = arrGen.countGreaterThan(intArr, 5);
        System.out.println("There are "+ num+ " elements in array greater than 5");

    }

//    static void checking() {
//        List<String> str = new ArrayList<>();
//        List<Object> obj = str;
//    }
}


//class WarningDemo {
//    static Box createBox() {
//        return new Box();
//    }
//
//    public static void main(String[] args) {
//        Box<Integer> box ;
//        box = createBox();  Warning: Unchecked assignment.
//    }
//}
