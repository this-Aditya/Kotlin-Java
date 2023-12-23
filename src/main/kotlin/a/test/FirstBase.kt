package a.test

import java.io.IOException

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
//    println(baseUrl!!.port)
//    val strippedPath = "https://stage.jhfgzdkhggrhzgd.net/management/portal/studies/subjects"
//    val builderUrl = baseUrl.newBuilder(strippedP ath)
//    val finalUrl = builderUrl?.build();
//    println(finalUrl)
//    var x = 2
//    val y = ++x
//    println(y)

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
//    println(test2(9))
//    val ref: (String) -> Int? = ::demoFun
//    val x = ref("45789345")
//    println(x)
//checkXTExecution()
    test4(45).also {
        println(it)
    }.let {
        StringBuilder(it).append(": A Mathematical number").toString()
    }.apply {
         this.substring(1, this.length - 3)
    }.also {
        println(it)
    }
}

fun demoFun(age: String): Int? {
    return try {
        age.toInt()
    } catch (ex: NumberFormatException) {
        null
    }
}

fun checkXTExecution() {
    println("Hello there!").also {
        println("I am intellij")
    }
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
        try {
            test3(param)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    try {
        test1()
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
    return "Function completed"
}

@Throws(IOException::class)
fun test1(): String {
throw IOException()}

fun test3(param: Int) {
    if (param > 8) {
        throw NumberFormatException()
    }
}

fun test4(ip: Int): String {
    return ip.toString()
}

fun no() {
    val needsPermissions: MutableSet<String> = hashSetOf()
}



fun test5() {
    fun f(): String = "Test"
    val foo = ::f as () -> String
    fun bar(doSomething: () -> String) { doSomething() }

    val baz = bar(::f)  // OK
    val baz2 = bar(foo) // Error
}

