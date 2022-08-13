package com.pattern.gof.chapter3

class CalculateNumber2{

    fun doCalculate(callback: CallBack):Int{
        return callback.doSomething()
    }

}

interface CallBack{
    val num1:Int
    val num2: Int
    fun doSomething(): Int
}

class PlusCallBack(override val num1: Int, override val num2: Int) : CallBack {
    override fun doSomething(): Int = num1 + num2
}


class MultiplyCallBack(override val num1: Int, override val num2: Int) : CallBack {
    override fun doSomething(): Int = num1 * num2
}
