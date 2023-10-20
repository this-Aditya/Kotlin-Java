package f.io_streams.streams.file_streams.objects_io.withFile

import f.io_streams.streams.file_streams.objects_io.objects.Bike
import f.io_streams.streams.file_streams.objects_io.objects.Dog
import f.io_streams.streams.file_streams.objects_io.objects.Man
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class AObjectIO {
    val aditya = Man("Aditya", Dog("Brownie", "labrador"), Bike("Mishra's","Royal Enfield", "Classic 350", "Chrome Bronze"))
    private val inputFile = File("E:\\Learning\\LanguagePractice\\Kotlin-2023\\Kotlin-2023\\src\\main\\kotlin\\f\\io_streams\\streams\\file_streams\\objects_io\\input.txt")
    private val outputFile = File("E:\\Learning\\LanguagePractice\\Kotlin-2023\\Kotlin-2023\\src\\main\\kotlin\\f\\io_streams\\streams\\file_streams\\objects_io\\output.txt")
    private val fileInputStream = FileInputStream(outputFile)
    private val fileOutputStream = FileOutputStream(outputFile)

    fun insertTheObject() {
        ObjectOutputStream(fileOutputStream).use {
            it.writeObject(aditya)
            it.writeBoolean(true)
        }
    }

    fun getInsertedObject() {
        try {
            ObjectInputStream(fileInputStream).use {
                val x = it.readObject() as Man
                println(x)
                println(it.readBoolean())
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}

fun main() {
    val instance = AObjectIO()
    instance.insertTheObject()
    instance.getInsertedObject()
}