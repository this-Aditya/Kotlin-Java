package org.example.zzb.bootcamp.b.generics.inheritance;

public class GenericList {
    public static void main(String[] args) {
//        GenericClass<Object> gc = new GenericClass<String>("Hello");  Gives error
//        GenericClass<Animal> ga = new GenericClass<Monkey>(new Monkey()); Again error
//        GenericClass<Monkey> gm = new GenericClass<Animal>(new Monkey()); One more error
//        This implies that generic types doesn't have the same relationships as the classes normally have!!

    }
}

class GenericClass<T> {
    private T value;

    public GenericClass(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
