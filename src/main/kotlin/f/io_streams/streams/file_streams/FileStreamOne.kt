package f.io_streams.streams.file_streams

import java.io.ByteArrayInputStream
import java.io.File
import java.io.FileInputStream

fun main() {
    val fileStream = FileStreamOne()
//    fileStream.performTask()
    fileStream.checkByteBuffer()
}
class FileStreamOne {
    fun performTask() {
        val input = FileInputStream("E:\\Learning\\LanguagePractice\\Kotlin\\Kotlin-Prac\\src\\main\\kotlin\\f\\io_streams\\streams\\input.txt")
        println("Available bytes in file: ${input.available()}")

        val bytes = ByteArray(100)
        println("Data read from file:")
        while (input.read(bytes) != -1) {
            println(String(bytes, 0, 100))
        }
        val str = "Hello this is aditya".toByteArray()
//        println(String(str))
        input.close()
    }

    fun performEfficientTask() {
        val file: File = File("E:\\Learning\\LanguagePractice\\Kotlin\\Kotlin-Prac\\src\\main\\kotlin\\f\\io_streams\\streams\\input.txt")
        file.inputStream().use {
            
        }
    }

    fun checkByteBuffer() {
        val data = byteArrayOf(-56)
        val byteStream = ByteArrayInputStream(data)
        println(byteStream.read())
    }
}


