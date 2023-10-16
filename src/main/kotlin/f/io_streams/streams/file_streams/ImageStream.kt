package f.io_streams.streams.file_streams

import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.lang.Exception

fun main() {
    val imageInputFile = File("E:\\Learning\\LanguagePractice\\Kotlin\\Kotlin-Prac\\src\\main\\kotlin\\f\\io_streams\\streams\\input.jpg")
    val imageOutPutFile = File("E:\\Learning\\LanguagePractice\\Kotlin\\Kotlin-Prac\\src\\main\\kotlin\\f\\io_streams\\streams\\output.jpg")
    val dataBytes = ByteArray(1024)

    try {
        imageInputFile.inputStream().use { input ->
            imageOutPutFile.outputStream().use { output ->
                var bytesRead: Int
                while (input.read(dataBytes).also { bytesRead = it } != -1) {
                    output.write(dataBytes, 0, bytesRead)
                }
            }
        }
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}