package a.test

import com.sun.jdi.Value

fun main() {
    val lon: Long = 768356238769834
    val doubles: Double = 89243.4
    checkString("One", "One")
    checkString("One", lon)
    checkString("One", true)
    checkString("One", 4.5f)
    checkString("One", doubles)

}

fun checkString(key: String, value: Any) {
    require(
        value is String || value is Long || value is Boolean || value is Int || value is Float
    ) { println("Cant put value $value into map") }

    var stringValue = value as? String
    stringValue?.let { println("First Transformation successful.. Value: $value") }
    if (stringValue == null) {
        println("First transformation failed, value: $value")
        stringValue = value.toString()
        if (stringValue is String) println("Successfully Casted... value: $value")
        else println("Successfully Failed")
    }
}

/**
 * First Transformation successful.. Value: One
 * First transformation failed, value: 768356238769834
 * Successfully Casted... value: 768356238769834
 * First transformation failed, value: true
 * Successfully Casted... value: true
 * First transformation failed, value: 4.5
 * Successfully Casted... value: 4.5
 * Cant put value 89243.4 into map
 * Exception in thread "main" java.lang.IllegalArgumentException: kotlin.Unit
 * 	at a.test.StringTestKt.checkString(StringTest.kt:17)
 * 	at a.test.StringTestKt.main(StringTest.kt:12)
 * 	at a.test.StringTestKt.main(StringTest.kt)
 */