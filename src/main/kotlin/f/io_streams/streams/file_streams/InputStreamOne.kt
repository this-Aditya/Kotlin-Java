package f.io_streams.streams.file_streams

import java.io.ByteArrayInputStream
import java.io.InputStream

fun main() {
    val bytes: ByteArray = byteArrayOf("f".toByte(), "u".toByte())
    val byte2 = ByteArray(5)
    val input: InputStream = ByteArrayInputStream(bytes)
    println(input.available())
    println(input.read(byte2))
    byte2.forEach { print("$it ") }
    println()
    println(input.available())
}