package com.pattern.gof.chapter3

import java.time.Instant

interface Strategy {
    fun doSomething()
}

class PrintStrategy : Strategy {
    override fun doSomething() {
        println("doSomething")
    }
}

class ShowNowUTCStrategy : Strategy {
    override fun doSomething() {
        println(Instant.now())
    }

}

class StrategyContext(
    private val strategy: Strategy
) {

    fun doAnyThing() {
        strategy.doSomething()
    }
}


fun main() {
    val strategyContext = StrategyContext(PrintStrategy())
    strategyContext.doAnyThing()

    val strategyContext2 = StrategyContext(ShowNowUTCStrategy())
    strategyContext2.doAnyThing()

}