package zza.java_cytpto.symmetric_cryptography

import java.math.BigInteger
import java.security.SecureRandom
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.IvParameterSpec

private fun main() {
    val keyGenerator: KeyGenerator = KeyGenerator.getInstance("AES")
    keyGenerator.init(192)

    val secretKey: SecretKey = keyGenerator.generateKey()

    val secureRandom: SecureRandom = SecureRandom.getInstance("SHA1PRNG")
    val randomByteArray = ByteArray(16)
    secureRandom.nextBytes(randomByteArray)

    // IV-Parameter Spec originates from Secure Random ( Up to my knowledge when I am writing this, this may be something other, I am just in my learning phase
    val ivSpec: IvParameterSpec = IvParameterSpec(randomByteArray)

    val inputDataBytes: ByteArray = "Hello World! ".repeat(16).toByteArray()

    val cipher: Cipher = Cipher.getInstance("AES/CBC/PKCS5PAdding")
    cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec)

    val encryptedByteData = cipher.doFinal(inputDataBytes)
    val encryptedHexData = BigInteger(1, encryptedByteData).toString(16)
    println("Encrypted data: $encryptedHexData")
    print("Encrypted Byte Data: ")
    encryptedByteData.forEach { print(it) }
    println()

    cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec)
    val decryptedByteData = cipher.doFinal(encryptedByteData)
    val decryptedReadableData = String(decryptedByteData)
    println("Decrypted Data: $decryptedReadableData")

}