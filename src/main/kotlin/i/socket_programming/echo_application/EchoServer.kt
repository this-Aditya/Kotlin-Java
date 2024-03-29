package i.socket_programming.echo_application

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.InetAddress
import java.net.ServerSocket

fun main() {
    try {
        var serverGets: String = "Hey"
        println("Waiting for clients...")
        val serverSocket = ServerSocket(7654, 0, InetAddress.getByName("127.0.0.1"))
        val socket = serverSocket.accept()
        println("Connection established")
        val bufferedReader = BufferedReader(InputStreamReader(socket.getInputStream()))
        while (serverGets!="bye") {
            println("In loop")
            serverGets = bufferedReader.readLine()
            val printWriter = PrintWriter(socket.getOutputStream(), true)
            println("Client says: $serverGets")
        }
        println("Server Terminated.")
    } catch (ex: Exception) {
        println(ex.message)
    }
}