package com.pattern.gof.chapter3

interface Status {
    fun print(name: String)
    fun addHistory(history: String)

}

class Default(val context: Context) : Status {

    override fun print(name: String) {
        throw UnsupportedOperationException()
    }

    override fun addHistory(history: String) {
        throw UnsupportedOperationException()
    }

}

class Active(val context: Context) : Status {
    override fun print(name: String) {
        println(name)
    }

    override fun addHistory(history: String) {
        context.histories.add(history)
    }
}

class Context {

    val histories = mutableListOf<String>()

    var status: Status = Default(this)

    fun print(name: String) {
        status.print(name)
    }

    fun changeStatus(status: Status) {
        this.status = status
    }

    fun addHistory(history: String) {
        status.addHistory(history)
    }

    fun printHistory(){
        for (history in histories) {
            this.print(history)
        }
    }
}


fun main() {
    val context = Context()
    try {
        context.print("ss")
        context.addHistory("추억")
    }catch (e: Exception){
        println("실패~")
    }

    context.changeStatus(Active(context))
    context.print("ss")
    context.addHistory("추억")

    context.printHistory()
}