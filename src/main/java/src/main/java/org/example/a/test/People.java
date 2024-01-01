package org.example.a.test;

import java.util.Objects;

public class People {
   String name;
   int age;

    People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return  false;
        }
        People people = (People) obj;
        return age == people.age && Objects.equals(name, people.name);
    }

    public static void main(String[] args) {
        People one = new People (null, 21);
        People two = new People (null, 21);

        System.out.println(one.equals(two));
    }
}
