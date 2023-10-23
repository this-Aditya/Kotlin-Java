package k.http_s.okHttp

import okhttp3.Credentials
import java.util.*

class EncodeCredentials {

}

fun main() {
    val s = Scanner(System.`in`)
    val username = s.nextLine()
    val secret = s.nextLine()

    val credentials =  "$username:$secret"

    val base64Cred = Base64.getEncoder().encodeToString(credentials.toByteArray())

    val authorization: String = "Basic $base64Cred"
    println(authorization)
}