package org.example.zzb.bootcamp.b.generics.inheritance;

import java.util.ArrayList;
import java.util.List;

public class GenericInheritance {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Name 1");
        names.add("Name 2");
        simpleSafePrint(names);

        List<String> moreNames = new ArrayList<>();
        moreNames.add("Name 1");
        moreNames.add("Name 2");
//        genericPrint(moreNames);
        /*
          Error in above statement:
          Required type:
          List
          <Objects>
          Provided:
          List
          <String>
         */
        unsafeGenericPrint(moreNames); // will works fine!!


        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(3);
//        genericPrint(moreNames);
        /**
         * Error in above statement:
         * Required type:
         * List
         * <Objects>
         * Provided:
         * List
         * <String>
         */
        unsafeGenericPrint(ints); // also working fine!!
    }


    static void genericPrint(List<Object> values) {
        values.forEach(System.out::println);
        values.add("This is why the error is thrown in above statements...");
        values.add("Because if we pass the list of integer as an argument then the string will get added!!");
    }

    static void simpleSafePrint(List<String> names) {
        names.forEach(System.out::println);
    }

    static void unsafeGenericPrint(List<?> values) {
        Object o = values.get(1); // Return type for this is object for sure!!
//        values.add("Hello"); // Can't add anything to wildcard type
    }
}
