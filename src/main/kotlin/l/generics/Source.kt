package l.generics

interface Source<out T> {
    fun getT(): T
//    fun setT(t: T) {
//         Internal calculations
//    }
    // Above one will give error: Type parameter T is declared as 'out' but occurs in 'in' position in type T
}

private fun demo() {
    val strings: Source<String> = object : Source<String>{
        override fun getT(): String {
            return "This is a string!!"
        }
    }
//    val objects: Source<Any> = strings // Type mismatch....

    val objects: Source<Any> = strings
}