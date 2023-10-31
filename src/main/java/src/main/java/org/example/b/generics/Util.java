package org.example.b.generics;

public class Util {
    static <K, V> boolean compare(OrderedPair<K, V> p1, OrderedPair<K, V> p2) {
        return p1.getKey() == p2.getKey() && p1.getValue() == p2.getValue();
    }
}
