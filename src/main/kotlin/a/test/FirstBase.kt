package a.test

class FirstBase(
//    val y: String,
//    val a: String = "Primary".also { println("Statement of primary constructor.") }
) {
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

    val x: B = object : B, A(1) {
        override fun methodOne() {
            println("Hello from method one ")
        }
    }

//    val view = MyView("Hello");
//    println(view.a)

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























