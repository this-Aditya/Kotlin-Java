package org.example.zzb.bootcamp.a.collections.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashMapExample {

    public static void main(String[] args) {

        Map<Key,Value> myMap = new HashMap<>();

        myMap.put(new Key(1), new Value(11));
        myMap.put(new Key(2), new Value(11));
        myMap.put(new Key(3), new Value(12));
        myMap.put(new Key(2), new Value(12));
        myMap.put(new Key(1), new Value(11));

        System.out.println(myMap);
        System.out.println(myMap.values());

    }
}

class Key {
    int id;

    public Key(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Key(" + id + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || obj.getClass() != getClass()) return false;
        Key key = (Key) obj;
        return key.id == id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class Value {
    int data;

    public Value(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Value("+data+")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value = (Value) o;
        return data == value.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
