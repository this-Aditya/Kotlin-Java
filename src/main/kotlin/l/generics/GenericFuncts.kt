package l.generics

fun main() {

}

fun <T> giveList(item: T): MutableList<T> {
    return mutableListOf<T>(item)
}

fun <T: CharSequence> T.toNumber(string: String): Number? {
    return  try {
        return string.toInt()
    } catch ( ex: Exception ) {
        println(ex)
        null
    }
}
