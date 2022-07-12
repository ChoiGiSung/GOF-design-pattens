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


//----------------- 패턴 적용 전

class Dog : Eating{
    override fun eat() {
        println("먹기")
    }
}


class Cat : Eating, Animal{
    override fun eat() {
        println("먹기")
    }

    override fun hunt() {
        println("사냥")
    }
}

// 점점 많은 상속
open class DefaultAnimal: Eating, Animal{
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun hunt() {
        TODO("Not yet implemented")
    }
}

class Bug : DefaultAnimal() {

}