package org.example.zzb.bootcamp.b.generics;

public class TypedArray {
    public static void main(String[] args) {

        String[] names = new String[5];
        safeAddToArray(names, "Name 1");
        safeAddToArray(names, "Name 2");
        unsafeAddToArray(names, 2);
        String firstValue = names[0];
    }

    static void safeAddToArray(String[] names, String name) {
        names[0] = name;
    }

    static void unsafeAddToArray(Object[] names, Integer value) {
        names[0] = value; // Throws: java.lang.ArrayStoreException!!
    }
}
