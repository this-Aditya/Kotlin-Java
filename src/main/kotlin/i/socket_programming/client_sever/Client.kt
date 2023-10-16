package i.socket_programming.client_sever

import java.net.ConnectException
import java.net.Socket

fun main() {
    println("Client: Started")
    try {
        val socket: Socket = Socket("127.0.0.1", 7865)
        println("Client: Connected at port $socket.")
    } catch (ex: ConnectException) {
        println("Client: Service is not running on server yet!")
    }
    catch (ex: Exception) {
        ex.printStackTrace()
    }
}