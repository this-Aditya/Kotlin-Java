package i.socket_programming.echo_application

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

fun main() {
    var clientSays: String = "Hello"
    try {
        println("Client: Started")
        val bufferedReader = BufferedReader(InputStreamReader(System.`in`))
        val socket = Socket("127.0.0.1", 7654)
        val printWriter = PrintWriter(socket.getOutputStream(), true)
        while (clientSays != "bye") {
            print("Any message: ")
            clientSays= bufferedReader.readLine()
            printWriter.println(clientSays)
        }
        println("Client Terminated")
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}