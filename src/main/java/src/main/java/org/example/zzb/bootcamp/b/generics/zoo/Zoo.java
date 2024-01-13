package org.example.zzb.bootcamp.b.generics.zoo;

public class Zoo {

    public static void main(String[] args) {
        Cage<Lion> lionCage = new Cage<>();
        lionCage.setFirst(new Lion());
        lionCage.setFirst(new Lion());

        Cage<Monkey> mokeyCage = new Cage<>();
        mokeyCage.setFirst(new Monkey());
        mokeyCage.setFirst(new Monkey());

//        Cage<Monkey> constructorCage = new Cage<>(new Monkey(), new Lion()); // Error: Required Cage<Monkey>, but getting Cage<Animal>
//        Cage<Monkey> constructorCageA = new Cage(new Monkey(), new Lion()); // But no error here!!
//        Cage<Animal > cage = new Cage<>(new Monkey(), new Lion());// But no error here!!

        Cage<Monkey> constructorCage = new Cage<>(new Monkey(), new Monkey());

    }
}
