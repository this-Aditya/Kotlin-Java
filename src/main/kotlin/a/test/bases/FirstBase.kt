package a.test.bases

import okhttp3.HttpUrl.Companion.toHttpUrl

fun main() {
    val uri = "https://docker.kubernetes.com/path/path/"
    val httpUrl = uri.toHttpUrl().newBuilder("path/two");
    println(httpUrl)
}