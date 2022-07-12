package com.pattern.gof.chapter2

// 추상부(도구)와 구현부(사용)를 분리

//----------추상부-----------
interface Eating {
    fun eat()
}

class EatA : Eating {
    override fun eat() {
        println("eatA")
    }
}

class EatB : Eating {
    override fun eat() {
        println("eatB")
    }

}


//-------구현부

interface Animal {
    fun hunt()
}

class Bird(
    private val eat: Eating
) : Animal {
    override fun hunt() {
        eat.eat()
    }
}

class Fish(
    private val eat: Eating
) : Animal {
    override fun hunt() {
        eat.eat()
    }
}


//------------클라이언트

fun main() {

    val fish = Fish(EatB())
    fish.hunt()
}

//------- 구현 부 매번 오버라이드 막기

open class DefaultEat: Eating{
    override fun eat() {
        print("냠")
    }
}

class EatC: DefaultEat()
class EatD: DefaultEat()
