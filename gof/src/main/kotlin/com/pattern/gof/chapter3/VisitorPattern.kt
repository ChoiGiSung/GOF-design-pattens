package com.pattern.gof.chapter3


interface Element{
    fun accept(visitor: Visitor)
}

class Circle: Element{
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }
}

class Star: Element{
    override fun accept(visitor: Visitor) {
        visitor.visit(this)
    }

}

interface Visitor{
    fun visit(circle: Circle)
    fun visit(star: Star)
}

class ConcreteVisitor: Visitor{
    override fun visit(circle: Circle) {
        println("${this.javaClass.name} and ${circle.javaClass.name}")
    }

    override fun visit(star: Star) {
        println("${this.javaClass.name} and ${star.javaClass.name}")
    }
}

class NewVisitor: Visitor{
    override fun visit(circle: Circle) {
        println("${this.javaClass.name} and ${circle.javaClass.name}")
    }

    override fun visit(star: Star) {
        println("${this.javaClass.name} and ${star.javaClass.name}")
    }

}


fun main() {
    val element = Circle()
    val concreteVisitor = ConcreteVisitor()
    val newVisitor = NewVisitor()

    element.accept(concreteVisitor)
    element.accept(newVisitor)
}
