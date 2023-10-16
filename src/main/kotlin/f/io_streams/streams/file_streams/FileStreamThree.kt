package f.io_streams.streams.file_streams

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

fun main() {
    var inputFile: InputStream? = null
    var outputFile: OutputStream? = null

    try {
     inputFile = FileInputStream("E:\\Learning\\LanguagePractice\\Kotlin\\Kotlin-Prac\\src\\main\\kotlin\\f\\io_streams\\streams\\input.txt")
     outputFile = FileOutputStream("E:\\Learning\\LanguagePractice\\Kotlin\\Kotlin-Prac\\src\\main\\kotlin\\f\\io_streams\\streams\\output.txt")
    val dataBytes = ByteArray(1)

    inputFile.use {
        while (it.available() > 0) {
            val x = it.read()
            outputFile.write(x)
        }
    }
    } catch (ex: IOException) {
        println("IO Exception occured: $ex")
    } finally {
        inputFile?.close()
        outputFile?.close()
    }

}