package zza.java_cytpto.cryptoHashing

import java.security.MessageDigest
import java.math.BigInteger

fun main() {
  "Let me Introduce you to Mudit's dog Bruno. He is german shepard breed dog.".`toSHA-256HashDigest`()
  "Let me Introduce you to Mudit's dog Bruno. He is german shepard breed dog.".`toSHA-256HashDigest`()
  "Let me Introduce you to Mudit's dog Bruno. He is german shepard breed Dog.".`toSHA-256HashDigest`()

}


fun String.`toSHA-256HashDigest`() {
    val messageDigest = MessageDigest.getInstance("SHA-256")
    val message: ByteArray = this.toByteArray()
    val digestedMessage = messageDigest.digest(message)
    println("Input: $this")
    val hexString: String = BigInteger(1, digestedMessage).toString(16)
    println("Digested SHA-256 HASH: $hexString")

}
