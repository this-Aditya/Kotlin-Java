package org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo;

import org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo.activities.Eats;
import org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo.activities.Runs;
import org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo.activities.Sleeps;

class Cage <E extends Animal & Eats & Sleeps & Runs> {

    public Cage(E first, E second) {
        this.animal1 = first;
        this.animal2 = second;
    }

    public Cage() {

    }

    private E animal1;
    private E animal2;

    public E getAnimal1() {
        return animal1;
    }

    public void setAnimal1(E animal1) {
        this.animal1 = animal1;
    }

    public E getAnimal2() {
        return animal2;
    }

    public void setAnimal2(E animal2) {
        this.animal2 = animal2;
    }

    boolean areCompatible() {
        return animal1.getType().equals(animal2.getType());
        /*
        * We can access the properties of Animal class because of the
        * `? extends Animal` */
    }

    void feedAnimal() {
        animal1.eat();
        animal1.sleep();
        animal2.eat();
        animal2.sleep();
        // We are able to access these methods just because the type of Animal `E` is also
        // extending the Eats and Sleep
    }

    static <E extends Animal>boolean areStaticCompatible(E animal1, E animal2) {
        return animal1.getType().equals(animal2.getType());
    }
}
