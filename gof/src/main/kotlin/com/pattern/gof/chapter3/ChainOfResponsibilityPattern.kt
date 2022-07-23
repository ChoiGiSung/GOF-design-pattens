package com.pattern.gof.chapter3

abstract class PointCondition{
    abstract val nextCondition: PointCondition?
    abstract fun increasePoint()
}

class DefaultPointCondition(override val nextCondition: PointCondition?): PointCondition() {
    override fun increasePoint() {
        println("do something")
        nextCondition?.increasePoint()
    }
}

class ReadPointCondition(override val nextCondition: PointCondition?): PointCondition() {
    override fun increasePoint() {
        println("do something")
        nextCondition?.increasePoint()
    }
}

class PrintPointCondition(override val nextCondition: PointCondition?): PointCondition() {
    override fun increasePoint() {
        println("do something")
        nextCondition?.increasePoint()
    }
}

fun main() {
    val pointCondition: PointCondition =PrintPointCondition(ReadPointCondition(DefaultPointCondition(null)))

    pointCondition.increasePoint()
}
