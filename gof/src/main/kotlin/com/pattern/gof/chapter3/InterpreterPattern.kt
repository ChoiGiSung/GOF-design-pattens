package com.pattern.gof.chapter3

import java.util.*

interface Parser {
    fun parser(expression: String): Extension
}

interface Extension {
    fun interpreter(context: Map<Char, Int>): Int
}

class PlusExtension(
    private val left: Extension,
    private val right: Extension
) : Extension {
    override fun interpreter(context: Map<Char, Int>): Int {
        return left.interpreter(context) + right.interpreter(context)
    }
}

class MinusExtension(
    private val left: Extension,
    private val right: Extension
) : Extension {
    override fun interpreter(context: Map<Char, Int>): Int {
        return right.interpreter(context) - left.interpreter(context)
    }
}

class ValueExtension(
    private val char: Char
) : Extension {
    override fun interpreter(context: Map<Char, Int>): Int {
        return context[this.char] ?: 0
    }
}


class PostFixParser() : Parser {

    override fun parser(expression: String): Extension {
        val stack: Stack<Extension> = Stack()
        for (char in expression.toCharArray()) {
            stack.push(getExpression(char, stack))
        }
        return stack.pop()!!
    }

    private fun getExpression(char: Char, stack: Stack<Extension>): Extension {
       return when (char) {
            '+' -> PlusExtension(stack.pop(), stack.pop())
            '-' -> MinusExtension(stack.pop(), stack.pop())
            else -> ValueExtension(char)
        }
    }

}

fun main() {
    val extension = PostFixParser().parser("xyz+-")
    val result = extension.interpreter(mapOf('x' to 1, 'y' to 2,'z' to 3))
    println(result)
}


