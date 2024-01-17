package i.socket_programming

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

fun main() {
    try {
        val externalIp = getExternalIPAddress()
        println("Your External IP Address is: $externalIp")
    } catch (e: IOException) {
        e.printStackTrace()
    }
}

@Throws(IOException::class)
private fun getExternalIPAddress(): String {
    val url = URL("http://checkip.amazonaws.com/")
    val connection = url.openConnection() as HttpURLConnection

    return try {
        BufferedReader(InputStreamReader(connection.inputStream)).use {
            it.readLine()
        }
    } finally {
        connection.disconnect()
    }
}
