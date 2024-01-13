package zzc.bootcamp.b.classes_and_objects.c.inheritance

import javax.naming.Context

open class Base()

class Derived(p: Int) : Base() {
}


open class Parent(val name: String)

class Child : Parent {

    constructor(school: String, parentName: String) : super(parentName)

    constructor(parentName: String): super(parentName)
}

open class Shape {
    open val sides: Int = 0
}

open class Rectangle {
    open fun draw() {
        println("Drawing the rectangle!!")
    }
}

interface Polygon {

    fun draw() {
        println("Drawing a rectangle: Interface")
    }
}

class Square : Rectangle(), Polygon {
    override fun draw() {

    }
}


abstract class Work {
    fun doWork() {

    }
}