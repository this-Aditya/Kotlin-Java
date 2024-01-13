package org.example.zzb.bootcamp.a.collections.base;

import java.util.Date;
import java.util.Objects;

class Person {
    String firstName;
    String lastName;
    Date lastModified;
    int age;

    public Person(String firstName, String lastName, Date lastModified, int age) {
        System.out.println("Initialized");
        this.firstName = firstName;
        this.lastName = lastName;
        this.lastModified = lastModified;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Foo", "Bar", new Date(), 25);
        Person p2 = new Person("Foo", "Bar", new Date(), 25);
        System.out.println(p1.equals(p2));
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());

//        for (int i = 0; i < 1000000000; i++) {
//            new Person("ngs","dfushn", new Date(), 34);
//        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }
}
