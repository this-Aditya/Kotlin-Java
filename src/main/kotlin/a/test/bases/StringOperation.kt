package a.test.bases

fun main() {
trimString()
}

fun trimString() {
    val word = " \n  Hello this is the word.   "
    println(word)
    val trimmed = word.takTrimmedValues()
    println(trimmed)

}

fun String.takTrimmedValues(): String? = trim { it <= ' ' }
    .takeIf(String::isNotEmpty)