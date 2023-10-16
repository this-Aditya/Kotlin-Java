package b.introduction.b.null_safety

class Base {

}

/**
 * NULL Safety:
 * In an effort to rid the world of NullPointerException, variable types in Kotlin don't allow the assignment of null. If you need a variable that can be null, declare it nullable by adding ? at the end of its type.
 */

fun main() {
    var neverNull: String = "This can't be null"
    //neverNull = null Will give the compile time error

    var nullable: String? = "You can keep a null here"
    nullable = null

    // When inferring types, the compiler assumes non-null for variables that are initialized with a value.
    var inferredNonNull = "The compiler assumes non-null"
    //inferredNonNull = null Will give compilation error

//    fun strLength(notNull: String): Int {
//        return notNull.length
//    }
//    strLength(neverNull)
    //strLength(nullable) error 



}