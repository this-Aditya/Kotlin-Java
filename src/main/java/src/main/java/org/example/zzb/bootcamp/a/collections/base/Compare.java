package org.example.zzb.bootcamp.a.collections.base;

import java.util.*;

class Student implements Comparable<Student>{
    String name;
    int roll;
    double weight;

    public Student(String name, int roll, double weight) {
        this.name = name;
        this.roll = roll;
        this.weight = weight;
    }

    @Override
    public int compareTo(Student o) {
        System.out.println("Students: CompareTo");
        return Integer.compare(roll, o.roll);
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', roll=" + roll + ", weight=" + weight + '}';
    }
}

class Test {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alok", 4, 47.6));
        students.add(new Student("Aditi", 2, 40.0));
        students.add(new Student("Aman", 5, 43.5));
        students.add(new Student("Aditya", 3, 48.3));
        students.add(new Student("Abhay", 1, 45.5));

//        Uses the natural ordering for comparision!!
//        Collections.sort(students);

        // using the total ordering here!! passing the weight comparator!!

//        WeightComparator wc = new WeightComparator();
//        students.sort(wc);

        // Passing the implementation of comparator directly!!
        students.sort((Student s1, Student s2) ->
                Double.compare(s1.weight, s2.weight));
        System.out.println(students);
    }

}

class WeightComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return Double.compare(o1.weight, o2.weight);
    }
}
