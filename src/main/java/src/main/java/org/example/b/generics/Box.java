package org.example.b.generics;


/**
 * Below is the reason why we use generics
 */
//public class Box {
//    Object object;
//    void setObject(Object object) {
//        this.object = object;
//    }
//    Object getObject() {
//        return object;
//    }
//
//    public static void main(String[] args) {
//        Box box = new Box();
//        box.setObject("Hello");
//        int a = box.getObject();
//    }
//}

/**
 * Box class modified in generic way,
 * @param <T> the typed parameter of the Box class
 */
public class Box<T> {
    private T t;
    public void set(T t) {
        this.t = t;
    }
    public T get() {
        return t;
    }

    public <U extends CharSequence> void inspect(U u) {
        System.out.println("U: "+u.getClass().getName());
        System.out.println("T: "+t.getClass().getName());
    }
}