package com.pattern.gof.chapter3

abstract class CalculateNumber{

    fun doCalculate(num1:Int,num2:Int):Int{
        println("1: $num1, 2:$num2 ")
        return doSomething(num1,num2)
    }

    abstract fun doSomething(num1: Int, num2: Int) : Int
}


class PlusNumber: CalculateNumber() {
    override fun doSomething(num1: Int, num2: Int) = num1 + num2
}

class MultiplyNumber: CalculateNumber(){
    override fun doSomething(num1: Int, num2: Int) = num1 * num2
}
