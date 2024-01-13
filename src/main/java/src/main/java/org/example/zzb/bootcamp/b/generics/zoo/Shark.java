package org.example.zzb.bootcamp.b.generics.zoo;

import org.example.zzb.bootcamp.b.generics.zoo.activities.Eats;
import org.example.zzb.bootcamp.b.generics.zoo.activities.Sleeps;
import org.example.zzb.bootcamp.b.generics.zoo.activities.Swims;

public class Shark extends Animal implements Eats, Sleeps, Swims {

    String name = "Shark";

    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void swim() {

    }
}
