package org.example.b.generics;

import java.util.Collections;
import java.util.List;

class MyClass<T> {
    public <X>MyClass(X val) {
    ////
    }

    void sayHello() {
        System.out.println("Hello");
    }

    public static void main(String[] args) {
        MyClass<Integer> myClass = new MyClass<>("String Arg...");
        List<String> strs = Collections.emptyList();
    }
}
