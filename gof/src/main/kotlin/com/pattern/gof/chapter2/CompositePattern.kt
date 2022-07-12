package com.pattern.gof.chapter2

interface Component{
    fun calcPrice() : Int
}

class Bag : Component{

    val price: Int = 1000
    var items: List<Component> = listOf()

    override fun calcPrice(): Int {
        return items.map { it.calcPrice() }.sum()
    }
}

class Item : Component{
    val price: Int = 100

    override fun calcPrice(): Int {
        return price
    }

}

