package org.example.collections.set;

import java.util.HashSet;
import java.util.TreeSet;

// Comparable used for TreeSet!!
class Person implements Comparable<Person>{
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    String name;
    int age;

    @Override
    public int compareTo(Person o) {
        return Integer.compare(this.age, o.age);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;
        return age == person.age && name.equals(person.name);
    }

//     If not properly implemented the hashcode method, it will break the functionality of hashcode to store unique elements.
    @Override
    public int hashCode() {
        return 31 * name.hashCode() + age;
    }
}

class HashSets {

    public static void main(String[] args) {
        HashSet<Person> peoples = new HashSet<>();
        peoples.add(new Person("Alice", 30));
        peoples.add(new Person("Alice", 30));
        peoples.add(new Person("Aashi", 21));
        for (Person person: peoples) {
            System.out.println(person.name + ", "+ person.age);
        }
        System.out.println(new Person("Alice", 30).hashCode());
        System.out.println(new Person("Alice", 30).hashCode());

        TreeSet<Person> sortedPersons = new TreeSet<>();
        sortedPersons.add(new Person("Alice", 30));
        sortedPersons.add(new Person("Alice", 30));
        sortedPersons.add(new Person("Aashi", 21));
        sortedPersons.add(new Person("Awasthi", 19));
        for (Person person: sortedPersons) {
            System.out.println(person.name + ", "+ person.age);

        }
    }

}
