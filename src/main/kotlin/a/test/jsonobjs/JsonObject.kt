package a.test.jsonobjs

import org.json.JSONObject

fun main() {
//    jsonStringWay()
    jsonObjectWay()
}


fun jsonStringWay() {
    val jsonString = """{"sourceTypeId": 123, "sourceTypeProducer": "PRODUCER", 
                    "sourceTypeModel": "MODEL", "sourceTypeCatalogVersion": "v1",
                    "dynamicRegistration": true}"""

    println(jsonString)


    val obj = JSONObject(jsonString)
    println(obj)
//  {"sourceTypeProducer":"PRODUCER","sourceTypeCatalogVersion":"v1",
//  "dynamicRegistration":true,"sourceTypeModel":"MODEL","sourceTypeId":123}

    obj.keys().forEach(::println)
//  sourceTypeProducer
//  sourceTypeCatalogVersion
//  dynamicRegistration
//  sourceTypeModel
//  sourceTypeId

    obj["sourceTypeId"]?.let(::println) // 123
}

fun jsonObjectWay() {
    val json = JSONObject()
    json.put("sourceTypeId", 456)
    json.put("sourceTypeProducer", "ANOTHER_PRODUCER")
    json.put("sourceTypeModel", "ANOTHER_MODEL")
    json.put("sourceTypeCatalogVersion", "v2")
    json.put("dynamicRegistration", false)

}






