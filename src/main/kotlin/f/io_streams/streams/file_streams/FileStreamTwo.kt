package f.io_streams.streams.file_streams

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.lang.Exception
import kotlin.system.measureTimeMillis

lateinit var dataBytes: ByteArray
fun main() {
    try {
        val output: OutputStream = FileOutputStream("E:\\Learning\\LanguagePractice\\Kotlin\\Kotlin-Prac\\src\\main\\kotlin\\f\\io_streams\\streams\\output.txt", false)
        val input: InputStream = FileInputStream("E:\\Learning\\LanguagePractice\\Kotlin\\Kotlin-Prac\\src\\main\\kotlin\\f\\io_streams\\streams\\input.txt")
        var attempts = 0
        val tt = measureTimeMillis {
            dataBytes = ByteArray(210000000)
           var aval = 2
            val t = measureTimeMillis {
                aval = input.available()
            }
            println("Input available $t, avail: $aval")
            println("Input read ")
            println("Input available $t, avail: ${input.available()}")
            input.read(dataBytes)
        }
        println("Data Bytes t: $tt")
        val timeTaken = measureTimeMillis {

                val x = measureTimeMillis {
                    output.write(dataBytes)
                }
                println("Output written $x ")
        }
        println("Time: $timeTaken")
    } catch (ex: Exception) {
        println("Exception Occured: $ex")
    }
}