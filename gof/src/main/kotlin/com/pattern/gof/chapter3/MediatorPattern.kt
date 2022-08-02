package com.pattern.gof.chapter3

interface FrontDesk {
    fun cleanHard()
    fun dinnerFast()
    fun getGuest()
}

interface Service {
    fun service()
}

class CleanService(
) : Service {
    override fun service() {
        println("clean")
    }
}

class DinnerService(
) : Service {
    override fun service() {
        println("dinner")
    }
}

class ConcreteMediator(
    private val cleanService: CleanService,
    private val dinnerService: DinnerService
) : FrontDesk {

    override fun cleanHard() {
        cleanService.service()
    }

    override fun dinnerFast() {
        dinnerService.service()
    }

    override fun getGuest() {
        println("guest")
    }

}

fun main() {

    val concreteMediator = ConcreteMediator(CleanService(), DinnerService())

    concreteMediator.cleanHard()
    concreteMediator.dinnerFast()
}

