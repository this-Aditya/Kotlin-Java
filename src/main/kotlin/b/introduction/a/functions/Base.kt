package b.introduction.a.functions

/**
 * Simple Functions
 */

fun printMessage(message: String) {
    println(message)
}

fun printMessageWithPrefix(message: String, prefix: String = "Info") {
    println("$prefix $message")
}

fun sum(x: Int, y: Int): Int {
    return x + y
}

fun multiply(x: Int, y: Int) = x * y


/**
 * Infix Functions: Member functions and functions with single parameter can be turned into infix functions
 */

//infix fun Int.times(message: String) = message.repeat(this)

infix fun String.onto(other: String) = Pair(this, other)

/**
 * Operator functions: Operator functions in kotlin are special functions that allows you to define
 * how operators (such as +, -, *, /, ==, !=, >, <, etc.) works on the instances of your own custom
 * classes. These functions are defined using specific names and are prefixed with operator keyword.
 * By overloading these operator functions, you can customize the behaviour of the operator for your
 * own types.
 * For Example:
 *  * operator fun plus(other: MyClass): MyClass overloads the `+` operator for instances of MyClass.
 *  * operator fun compareTo(other: MyClass): Int overloads the comparison operator like >, <, >=, <= for instances of MyClass.
 */

operator fun Int.times(str: String) = str.repeat(this)

operator fun String.get(range: IntRange) = substring(range)


// Functions with VarArg parameters

fun printAll(vararg messages: String) {
    println(messages.joinToString(", ") { it })
}

fun printAllWithPrefix(vararg message: String, prefix: String) {
    println(message.joinToString(", ") { "$prefix $it" })
}

fun log(vararg entries: String) {
    printAll(*entries) // Inside the function body, varargs are treated as the array,
    // To send them again as vararg parameters we can use `*` inorder to spread these again as string
}





fun main() {
    // Normal Functions
//    printMessage("Hello")
//    printMessageWithPrefix("Hello", "Log")
//    printMessageWithPrefix("Hello")
//    printMessageWithPrefix(message = "Hello", prefix = "Log")
//    println(sum(1,2))
//    println(multiply(3,4))

    // Infix Functions
//    println(3 times "Morning ")
//    val pair = "Ferrari" to "Katrina"
//    println(pair)
//    val myPair = "Aditya" onto "RADAR-base"
//    println(myPair)
//    val sophia = Base("Sophia")
//    val claudia = Base("Claudia")
//    println((sophia likes claudia))

    // Operator functions
//    println(2 * "Bye ") // Overloaded the times operator function for string arguments.
//    val str = "Blue eyes hypnotise teri kardi hai menu. I swear choti dress me bomb lagdi menu, menu, menu."
//    println(str[0..40])

    // VarArg Functions
//    printAll("Hello", "Hallo", "Salut", "Hola", "你好")
//    printAllWithPrefix(
//        "Hello", "Hallo", "Salut", "Hola", "你好",
//        prefix = "Greeting:"                                          // 4
//    )


}







// Assume Base class as a `Person` class
class Base(private val name: String) {
private val likedPeople = mutableListOf(this)
    // Here the containing class becomes the first Parameter, there is no need to explicitly mention Base.likes
    infix fun likes (person: Base): Base = apply {
        likedPeople.add(person)
        likedPeople.add(Base("Karina"))
    }

    override fun toString(): String {
        return likedPeople.joinToString(", ") { it.name }
    }
}





