package a.test

import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import java.io.IOException
import java.util.AbstractMap
import java.util.concurrent.TimeUnit

class FirstBase(
    val y: String = "yjh"
    //    val a: String = "Primary".also { println("Statement of primary constructor.") }
) {

    inner class Two {
        val a = y
    }

    class Three {
//        val a = y
        val d = 74
    }
    init {
    }
val one = 1
    object Helllo {
     private val e = 5
        const val pne = "jehkhfewil"
    }
    companion object Helllo2 {
        const val pne = "jehkhfewil"
        val x = FirstBase()
    }
//    init {
//        println("Statement of Init")
//    }
//
//    constructor(b: String = "Secondary".also { println("Statement of secondary constructor") }) : this(y = b)
//
//    val x = "Main".also {
//        println("In the main section of class")
//    }
//    val p: String by lazy {
//        "Hello it is a lazy string".also {
//            println("Lazy string is initialized")
//        }
//    }

    private var first = 1
        set(value)  {
            field = value
            println("Setting first value as $value")
        }
    private var second = 2
        set(value) {
            field = value
            println("Setting second value as $value")
        }
    fun doSwap() {
        first = second.also {
            second = first
            println("In the '.also' block swapping value of first and second")
        }
    }
}

fun main() {
//    val firstBase = FirstBase()
//    firstBase.doSwap()

//    val x: B = object : B, A(1) {
//        override fun methodOne() {
//            println("Hello from method one ")
//        }
//    }

//    val view = MyView("Hello");
//    println(view.a)

    // Just curious
//    val x = true
//    println(x)
//    println(FirstBase::class.java)
//    println(SecondBase::class.java)
//    val baseUrl = "https://stage.jhfgzdkhggrhzgd.net".toHttpUrlOrNull()
//    println(baseUrl)
//    val x = FirstBase.Three() // can be called as it is an static class
//    val y = FirstBase.Two() can't be called as it is not an static class

//    val a: MutableList<Map.Entry<String, String>> = mutableListOf(AbstractMap.SimpleEntry("name", "Aditya"), AbstractMap.SimpleEntry("state", "Rajasthan") )
//    val firstEntry = a[0]
//
//
//    val b: MutableList<Map<String, String>> = mutableListOf(mapOf("name" to "Aditya"), mapOf("state" to "Rajasthan") )
//    val c : Map<String, String> = mapOf("name" to "Aditya", "state" to "Rajasthan", "city" to "Kuchaman", "work" to "Software Developer")
//    val d: MutableList<Map.Entry<String, String>> = c.entries.toMutableList()
//    println(d[1].component2())
//    println(d)
//    println(c)
//    d.forEach {
//        println("${it.key} -> ${it.value}")
//    }


//    val entry1 = AbstractMap.SimpleImmutableEntry("name", "Aditya")
//    val entry2 = AbstractMap.SimpleEntry("state", "Rajasthan")

    // Modify the key and value
//    entry1.key = "newKey"
//    entry1.value = "newName"
//
//    entry2.key = "newState"
//    entry2.value = "newRajasthan"


//    val time = TimeUnit.SECONDS.toMillis(5)
//    println(time)
    println(test2(7))
}

open class A(val a: Int) {
    open val variable: Int = 3
}

interface B {
    fun methodOne()
}

class MyView : View {
constructor(a: String): super(a)
constructor(a: String, b: Int): super(a)
}

open class View(val a: String) {}
















fun test2(param: Int): String? {
    if (param > 5 ) {
        try {
            test1()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
    return null
}

@Throws(IOException::class)
fun test1(): String {
    return "test1"
}




