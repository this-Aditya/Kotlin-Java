package i.socket_programming

import java.net.InetAddress
import java.net.UnknownHostException


object GetIPAddress {
    @JvmStatic
    fun main(args: Array<String>) {
        try {
            // Get the local host
            val localhost = InetAddress.getLocalHost()

            // Get the IP address
            val ipAddress = localhost.hostAddress
            println("Your IP Address is: $ipAddress")
        } catch (e: UnknownHostException) {
            e.printStackTrace()
        }
    }
}

