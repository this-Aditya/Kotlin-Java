package f.io_streams.reader_writer.buffered_reader.inputstream_reader

import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import kotlin.system.measureTimeMillis

val inputFile = File("E:\\Learning\\LanguagePractice\\Kotlin\\Kotlin-Prac\\src\\main\\kotlin\\f\\io_streams\\reader_writer\\buffered_reader\\input.txt")
val inputFile2 = File("E:\\Learning\\LanguagePractice\\Kotlin\\Kotlin-Prac\\src\\main\\kotlin\\f\\io_streams\\reader_writer\\buffered_reader\\input2.txt")
val fileInputStream = FileInputStream(inputFile)
val fileInputStream2 = FileInputStream(inputFile2)
val inputStreamReader = InputStreamReader(fileInputStream)
val inputStreamReader2 = InputStreamReader(fileInputStream2)
val bufferedReader = BufferedReader(inputStreamReader)
val bufferedReader2 = BufferedReader(inputStreamReader2)
val data1 = CharArray(1024)
val data2 = CharArray(1024)

fun main() {
    val timeWithBuffer = measureTimeMillis {
        withBuffer()
    }
    println("Time taken with buffer: $timeWithBuffer ms")
    val timeWithoutBuffer = measureTimeMillis {
        withoutBuffer()
    }
    println("Time taken without buffer: $timeWithoutBuffer ms")
}

fun withBuffer() {
    var dataRead = bufferedReader.read(data1)
    var count = 1
    while (dataRead != -1) {
        dataRead = bufferedReader.read(data1)
    }
}


fun withoutBuffer() {
    var dataRead = inputStreamReader2.read(data2)
    while (dataRead != -1) {
        dataRead = inputStreamReader2.read(data2)
    }
}

