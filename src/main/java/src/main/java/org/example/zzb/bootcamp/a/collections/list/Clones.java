package org.example.zzb.bootcamp.a.collections.list;

import java.util.ArrayList;
import java.util.List;

public class Clones {

    public static void main(String[] args) {
//        ArrayList<String> original = new ArrayList<>();
//        original.add("First");
//        original.add("Second");

//        List<String> cloned = (ArrayList<String>)original.clone();
//        original.set(0, "Third");
//        System.out.println("Original: "+ original);
//        System.out.println("Cloned: "+ cloned);
        /**
         * Original: [First, Second]
         * Cloned: [First, Second]
         */

        ArrayList<Student> students = new ArrayList<>();
        Student first = new Student("Abhay");
        students.add(first);
        students.add(new Student("Aditya"));

        ArrayList<String> cloned = (ArrayList<String>) students.clone();
//        students.set(0, new Student("Alok"));
         first.name = "Alok";
        System.out.println("Original: "+ students);
        System.out.println("Cloned: "+ cloned);
        /**
         * Original: [Student(Alok), Student(Aditya)]
         * Cloned: [Student(Alok), Student(Aditya)]
         */
    }
}


class Student {
    String name;
    Student() {

    }

    Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student("+ name +")";
    }
}
