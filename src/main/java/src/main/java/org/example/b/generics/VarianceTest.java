package org.example.b.generics;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class VarianceTest {
    public static void main(String[] args) {
        List<Grandparent> grand = new ArrayList<>();
        grand.add(new Parent());
        grand.add(new Grandparent());
        grand.add(new Child());
        // Above objects can be added to list of Grandparent but below can't...
//        grand.add(new GreatGrandParent());

//        List<? extends Grandparent> grandparents = new ArrayList<>();
//        grandparents.add(new Grandparent());  We can't do this way. We can only read from the list not write into it.

        List<? extends Grandparent> grandparents = grand;
//        Parent parent = grandparents.get(0); Not possible
        Grandparent gp = grandparents.get(0);

// -----------------------------------------------------------------------------------------------------

        List<? super Parent> family = new ArrayList<>();
        family.add(new Parent("Uncle"));
        family.add(new Child("Cousin"));
//        family.add(new Grandparent()); Can't do this too
//        family.add(new GreatGrandParent()); can't do this also, as parent is not directly subclassing it.
//        family.addAll(grand); Not possible here, possible at the time, if we assigned it directly to the family

//GreatGrandParent x = family.get(0);

        List<Number> num = new ArrayList<>();
        num.add(2);
        num.add(2.0);
        num.add(2L);

//        List<? extends Number> nums = new ArrayList<>();
        // Can't write to <? extends Number>
//        nums.add(Integer.valueOf(7));
//        nums.add(67);
//        nums.add(67.0);

        List<? extends Number> nums = num; // Can be done!!
    }
}

class GreatGrandParent {
    String name;

    public GreatGrandParent() {

    }

    public GreatGrandParent(String name) {
        this.name = name;
    }

    String name() {
        return Objects.requireNonNullElse(name, "GreatGrandParent");
    }
}

class Grandparent extends GreatGrandParent {

    public Grandparent() {

    }

    public Grandparent(String name) {
        this.name = name;
    }

    @Override
    String name() {
        return Objects.requireNonNullElse(name, "Grandparent");
    }
}

class Parent extends Grandparent {

    public Parent() {

    }

    public void Introduce() {
        System.out.println("Hello, I am a parent");
    }

    public Parent(String name) {
        this.name = name;
    }

    String name;

    @Override
    String name() {
        return Objects.requireNonNullElse(name, "Parent");
    }
}

class Child extends Parent {

    public Child() {

    }

    public Child(String name) {
        this.name = name;
    }

    String name;

    @Override
    String name() {
        return Objects.requireNonNullElse(name, "Child");
    }
}













