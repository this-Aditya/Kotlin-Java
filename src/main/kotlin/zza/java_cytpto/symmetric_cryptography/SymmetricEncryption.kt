package zza.java_cytpto.symmetric_cryptography

import java.math.BigInteger
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey

/**
 * KeyGenerator class is a part of the Java Cryptography Architecture (JCA) and provides a way to generate secret keys for various cryptographic algorithms.
 */
private fun main() {
    // KeyGenerator supports symmetric key algorithms, such as AES (Advanced Encryption Standard), DES (Data Encryption Standard)
    val keyGenerator: KeyGenerator = KeyGenerator.getInstance("AES")
    // specify we want a key of 192 bits specified foe AES
    keyGenerator.init(192)
    val secretKey: SecretKey = keyGenerator.generateKey()
    // Print the raw byte values of the secret key
    val rawSecretKeyBytes: ByteArray = secretKey.encoded
    print("AES Key (in bytes): ")
    rawSecretKeyBytes.forEach { print("$it ") }
    println()
    val keySizeInBits = secretKey.encoded.size * 8
    println("AES Key size (in bits): $keySizeInBits")

    // Initialize the Cipher for encryption
    val cipher = Cipher.getInstance("AES/ECB/PKCS5PAdding")
    cipher.init(Cipher.ENCRYPT_MODE, secretKey)

    // Data to be encrypted
    val plaintext = "Devoxx!!".repeat(16)
    val plaintextBytes = plaintext.toByteArray()
    // Encrypt the data
    val encryptedBytes: ByteArray = cipher.doFinal(plaintextBytes)
    // Print the encrypted data in Base64 format


//    val hexString = StringBuilder()
//    for (b in encryptedBytes) {
//        val hex = String.format("%02X", b)
//        hexString.append(hex)
//    }

    val encryptedData: String = BigInteger(1, encryptedBytes).toString(16)

//    val encryptedText: String = Base64.getEncoder().encodeToString(encryptedBytes)
    println("Encrypted Text (Base64): $encryptedData")

    cipher.init(Cipher.DECRYPT_MODE, secretKey)
    val decryptedBytes: ByteArray = cipher.doFinal(encryptedBytes)
    val decryptedData: String = String(decryptedBytes)
    println("Decrypted Data: $decryptedData")
}
