package com.pattern.gof.chapter2

class FontFactory {
    val store: MutableMap<String, Font> = mutableMapOf()

    fun getFont(name: String) = store.getOrPut(name) { Font(name) }
}

class Font(name: String)

fun main() {
    val factory = FontFactory()
    val 나눔 = factory.getFont("나눔")
    val 나눔2 = factory.getFont("나눔")

    println(나눔 == 나눔2)
}