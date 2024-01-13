package org.example.zzb.bootcamp.b.generics.zoo;

import org.example.zzb.bootcamp.b.generics.zoo.activities.Eats;
import org.example.zzb.bootcamp.b.generics.zoo.activities.Runs;
import org.example.zzb.bootcamp.b.generics.zoo.activities.Sleeps;

public class Monkey extends Animal implements Eats, Sleeps, Runs {
    String name = "Monkey";

    @Override
    public void eat() {

    }

    @Override
    public void run() {

    }

    @Override
    public void sleep() {

    }
}
