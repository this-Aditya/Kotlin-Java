package org.example.zzb.bootcamp.b.generics.upper_bound_wildcards.zoo;

public class Zoo {

    public static void main(String[] args) {
        Cage<Lion> lionCage = new Cage<>();
        lionCage.setAnimal1(new Lion());
        lionCage.setAnimal2(new Lion());

        Cage<Monkey> mokeyCage = new Cage<>();
        mokeyCage.setAnimal1(new Monkey());
        mokeyCage.setAnimal2(new Monkey());
        // Just Dummy Work!!



//        Cage<Monkey> constructorCage = new Cage<>(new Monkey(), new Lion()); // Error: Required Cage<Monkey>, but getting Cage<Animal>
//        Cage<Monkey> constructorCageA = new Cage(new Monkey(), new Lion()); // But no error here!!
//        Cage<Animal > cage = new Cage<>(new Monkey(), new Lion());// But no error here!!

        Cage<Monkey> constructorCage = new Cage<>(new Monkey(), new Monkey());

    }

    // Making use of upper bound wildcard
    private boolean isAnimalsCompatible(Cage<? extends Animal> cage) {
        Animal first = cage.getAnimal1();
        Animal second = cage.getAnimal2();

        return first.getType().equals(second.getType());
    }


    static void understandingMultipleExtensions() {
//        Cage<Shark> sharkCage = new Cage<Shark>(); // Don't works because Sharks is not extending the Runs
//        Cage<Ant> antCage = new Cage<Ant>(); // Again ant doesn't extends the Animal class!!
    }
}
