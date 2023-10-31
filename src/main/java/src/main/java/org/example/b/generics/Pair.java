package org.example.b.generics;

public interface Pair<K, V> {
    public K getKey();
    public V getValue();
}

class OrderedPair<K, V>  implements Pair<K, V>{

    private K key;
    private V value;

    OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }
}
