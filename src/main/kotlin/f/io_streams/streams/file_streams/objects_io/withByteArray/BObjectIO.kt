package f.io_streams.streams.file_streams.objects_io.withByteArray

import f.io_streams.streams.file_streams.objects_io.objects.Bike
import f.io_streams.streams.file_streams.objects_io.objects.Dog
import f.io_streams.streams.file_streams.objects_io.objects.Man
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

class BObjectIO {
    private val aditya = Man("Aditya", Dog("Brownie", "labrador"), Bike("Mishra's","Royal Enfield", "Classic 350", "Chrome Bronze"))
    private val data: ByteArray = ByteArray(1000)
    private val byteArrayOutputStream = ByteArrayOutputStream(1000)
    lateinit var storedObject: ByteArray

    fun insertSerializedObject() {
        byteArrayOutputStream.use { bo ->
            ObjectOutputStream(bo).use { it.writeObject(aditya) }
        }
        storedObject = byteArrayOutputStream.toByteArray()
    }

    fun getStoredObject(): Any? {
        return try {
            ByteArrayInputStream(storedObject).use { bi ->
                ObjectInputStream(bi).use {
                    it.readObject()
                }
            }
        }catch (ex: Exception) {
            ex.printStackTrace()
            null
        }
    }
}

fun main() {
    val instance = BObjectIO()
    instance.insertSerializedObject()
    val x = instance.getStoredObject()
    x?.let {
        println(it as Man)
    }
}