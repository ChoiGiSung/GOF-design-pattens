package com.pattern.gof.chapter3

class Subject {
    private val subscribers = mutableMapOf<String, MutableSet<Subscriber>>()

    fun add(subject: String, subscriber: Subscriber) {
        if (subscribers[subject] == null) {
            subscribers[subject] = mutableSetOf(subscriber)
        } else {
            subscribers[subject]!!.add(subscriber)
        }
    }

    fun remove(subject: String, subscriber: Subscriber) {
        subscribers[subject]?.remove(subscriber)
    }

    fun update(subject: String, doSomething: String) {
        val choiceSubscribers = subscribers[subject] ?: return

        for (subscriber in choiceSubscribers) {
            subscriber.sendMessage(doSomething)
        }
    }


}

interface Subscriber {
    fun sendMessage(doSomething: String)
}

class ConcreteSubscriber(val name: String) : Subscriber {
    override fun sendMessage(doSomething: String) {
        println("$name : $doSomething")
    }
}

fun main() {
    val subject = Subject()
    
    val user1 = ConcreteSubscriber("user1")
    val user2 = ConcreteSubscriber("user2")
    
    subject.add("경제",user1)
    subject.add("경제",user2)
    subject.add("물리",user1)
    
    subject.update("물리","시간표 바뀜")
    subject.update("경제","시간표 바뀜")

}