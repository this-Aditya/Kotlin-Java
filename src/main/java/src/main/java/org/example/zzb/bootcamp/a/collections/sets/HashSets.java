package org.example.zzb.bootcamp.a.collections.sets;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import static javax.xml.crypto.dsig.SignatureMethod.HMAC_SHA256;

public class HashSets {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();
        students.add(new Student("Abhay",10,1,45.0,"A"));
        students.add(new Student("Aditi",11,2,40.2,"B"));
        students.add(new Student("Aditya",11,3,46.3,"B"));
        students.add(new Student(null,11,2,40.2,null));
        students.add(new Student("Alok",10,4,43.6,"A"));
        students.add(new Student("Aman",10,4,43.6,"B"));
        students.add(new Student("Aditi",11,2,40.2,"B"));
        students.add(new Student(null,11,2,40.2,null));

        students.forEach(System.out::println);
    }
}

class Student {

    public Student(String name, int age, int roll, double weight, String section) {
        this.name = name;
        this.age = age;
        this.roll = roll;
        this.weight = weight;
        this.section = section;
    }

    {
        try {
            Mac sha256 = Mac.getInstance("HmacSHA256");

            // Generate a random key using KeyGenerator
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGen.generateKey();

            sha256.init(secretKey);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new RuntimeException(e);
        }
    }

    String name;
    int age;
    int roll;
    double weight;
    String section;

    Student() throws NoSuchAlgorithmException {
    }

    @Override
    public int hashCode() {
        String data = roll + section + name + age + weight;
        return Objects.hashCode(data);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        Student student = (Student) obj;
        return age == student.age
                && roll == student.roll
                && weight == student.weight
                && Objects.equals(section, student.section)
                && Objects.equals(name, student.name);
    }

    @Override
    public String toString() {
        return "Name: "+ name+", Age: "+age+", Section: "+section+", Weight: "+weight+",roll: "+roll;
    }
}
