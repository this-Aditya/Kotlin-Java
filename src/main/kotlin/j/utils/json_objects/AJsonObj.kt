package j.utils.json_objects

import org.json.HTTP
import org.json.JSONArray
import org.json.JSONObject
import java.lang.Boolean.TRUE


fun main() {
//    fromJsonObj()
//    fromMap()
//    fromJsonString()
//    fromJsonArrayOne()
//    fromDemoBean()
//    jsonArrayFromString()
//    jsonArrayFromArray()
//    toHTTPHeader()
    jsonArrayFromStringTwo()
}

fun fromJsonObj() {
    val jo = JSONObject()
    jo.put("name", "John Doe")
    jo.put("age", 22)
    jo.put("city", "Chicago")
    println(jo)
//    val jsonString = jo.toString()
//    println(jsonString)
}

fun fromMap() {
    val map: HashMap<String, String> = HashMap()
    map["name"] = "John Doe"
    map["age"] = "22"
    map["city"] = "Chicago"
    val jsonObject = JSONObject(map)
    println("Json Object constructed from Json Map: \n${jsonObject}")
}

fun fromJsonString() {
    val jsonString = "{\"name\":\"John Doe\", \"age\":\"22\", \"city\":\"Chicago\"}"
    val jsonObj = JSONObject(jsonString)
    println(jsonObj)
}

fun fromJsonArrayOne() {
    // Not this way :)
//    val jsonArray = arrayOf("name", "John Doe", "age", "21", "city", "Chicago")
//    val jsonObject = JSONObject(jsonArray)
//    println(jsonObject)

    val jsonArray = JSONArray()
    jsonArray.put(TRUE)
    jsonArray.put("lorem ipsum")
    val jsonObject = JSONObject("{\"name\":\"John Doe\", \"age\":\"22\", \"city\":\"Chicago\"}")
    jsonArray.put(jsonObject)
//    jsonArray.put(jsonArray)
    println(jsonArray)
}


class DemoBean(val name: String, val age: Int, val city: String)

fun fromDemoBean() {
    val demoBean = DemoBean("John Doe", 22,"Chocago")
    val jsonObject = JSONObject(demoBean)
    println(jsonObject)
}

fun jsonArrayFromString() {
    val jsonArray = JSONArray("[true, \"lorem ipsum\", 22, " +
            "{\"name\": \"John Doe\", \"age\":22, \"city\":\"Chicago\"}" +
            "]")
    println(jsonArray)
}

fun jsonArrayFromArray() {
    val array = arrayOf("California", "Texas", "Alaska", "Hawaii")
    val jsonArray = JSONArray(array)
    println(jsonArray)
}

fun toHTTPHeader() {
    val jo = JSONObject()
    jo.put("HTTP-Version", "HTTP/1.1")
    jo.put("Method", "POST")
    jo.put("User-Agent", "MyApp/1.0")
    jo.put("Accept", "application/json")
    jo.put("Content-Type", "application/json")
    jo.put("Authorization", "Bearer your_access_token")
    jo.put("Cookie", "sessionID=12345; user=JohnDoe")
    jo.put("Host", "www.example.com")
    jo.put("Request-URI", "http://www.example.com/")

    val httpStr = HTTP.toString(jo)
    println(httpStr)
}

fun jsonArrayFromStringTwo() {
    val jsonString = "[{\"name\":\"John Doe\", \"age\":\"22\", \"city\":\"Chicago\"}, true, 17, \"Julie\", {\"city\":\"Kuchaman\"}]"
    val jsonArray = JSONArray(jsonString)
    println("Complete Array-> $jsonArray")
    val firstObj = jsonArray.getJSONObject(0)
    val second = jsonArray.getBoolean(1)
    val third = jsonArray.getInt(2)
    val fourth = jsonArray.getString(3)
    val fifth = jsonArray.getJSONObject(4)
    val jsonList: MutableList<Any> = mutableListOf(firstObj, second, third, fourth, fifth)
    jsonList.forEach {
        println(it)
    }
}