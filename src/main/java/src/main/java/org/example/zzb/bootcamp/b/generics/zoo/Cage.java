package org.example.zzb.bootcamp.b.generics.zoo;

class Cage <E extends Animal> {

    public Cage(E first, E second) {
        this.first = first;
        this.second = second;
    }

    public Cage() {

    }

    private E first;
    private E second;

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }

    public E getSecond() {
        return second;
    }

    public void setSecond(E second) {
        this.second = second;
    }

    boolean areCompatible() {
        return first.getType().equals(second.getType());
        /*
        * We can access the properties of Animal class because of the
        * `? extends Animal` */
    }
}
