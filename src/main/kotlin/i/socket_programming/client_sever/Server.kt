package i.socket_programming.client_sever

import java.io.IOException
import java.net.InetAddress
import java.net.ServerSocket

fun main() {
    println("Server: Waiting for clients")
    try {
        val serverSocket: ServerSocket = ServerSocket(7865,0, InetAddress.getByName("127.0.0.1"))
        val socket = serverSocket.accept() // blocking call
        println("Serer: Connection established with client at port: ${socket.port}, and ip: ${serverSocket.inetAddress}")
    } catch (ex: IOException) {
        ex.printStackTrace()
    }
}