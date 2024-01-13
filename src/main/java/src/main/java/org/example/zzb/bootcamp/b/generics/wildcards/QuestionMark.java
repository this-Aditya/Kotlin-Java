package org.example.zzb.bootcamp.b.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class QuestionMark {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Name 1");
        names.add("Name 2");
        printList(names);
        List<Number> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(1);
        printList(numbers);

        List<?> temp = names;
        temp = numbers;
        Object o = temp.get(0);
//        temp.add("Hello"); // Won't work actually!!
        // By using the Generic wildcard `?` we loose the ability to modify the generic object, we can just read form that!!
    }

    static void printList(List<?> values) {
        values.forEach(System.out::println);
    }
}
