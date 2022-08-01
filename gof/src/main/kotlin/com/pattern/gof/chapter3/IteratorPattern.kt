package com.pattern.gof.chapter3

import java.util.*

interface ConcreteAggregate<T> {
    fun getIterator(): Iterator<T>
}

class RecentIterator(
    private val index: List<String>
) : Iterator<String>{

    private val iterator : Iterator<String>

    init {
        iterator = index.sortedBy { it.length }.reversed().listIterator()
    }

    override fun hasNext(): Boolean {
        return iterator.hasNext()
    }

    override fun next(): String {
        return iterator.next()
    }

}

class BookAggregate: ConcreteAggregate<String>{
    private val index: List<String> = listOf("1장","2장","3장")

    override fun getIterator(): Iterator<String> {
        return RecentIterator(index)
    }
}

fun main() {
    val books = BookAggregate()
    val booksIterator = books.getIterator()

    for (index in booksIterator) {
        println(index)
    }
}