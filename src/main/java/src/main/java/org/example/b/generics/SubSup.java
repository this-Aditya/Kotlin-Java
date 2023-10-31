package org.example.b.generics;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Sup<T> {
    public Sup() {
    }
}

class Sub<T> extends Sup<T> {
    public Sub() {
    }
}

class Test {
    public Test() {
    }

    public static void main(String[] args) {
        Sup<String> sp = new Sup<>();
        Sub<String> sb = new Sub<>();
        sp = sb;  // Casts successfully

//        ArrayList x = pick("s", new ArrayList<Integer>()); // Error: no instance(s) of type variable(s) exist so that String conforms to ArrayList
        Serializable x = pick("s", new ArrayList<Integer>()); // The inference algorithm automatically determines the return type
    }

    static <T> T pick(T a1, T a2) {
        return a2;
    }

}








