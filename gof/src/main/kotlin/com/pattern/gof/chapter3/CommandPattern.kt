package com.pattern.gof.chapter3

//receiver
class Light{
    fun on(){
        println("on")
    }
    fun off(){
        println("off")
    }
}

//commander
interface Command{
    fun execute()
}

class LightOnCommand(
    private val light: Light
):Command{
    override fun execute() {
        light.on()
    }
}

class LightOffCommand(
    private val light: Light
):Command{
    override fun execute() {
        light.off()
    }
}

//invoker
class Button(
    private val command: Command
){
    fun press(){
        command.execute()
    }
}


fun main() {
    val button = Button(LightOnCommand(Light()))
    val button2 = Button(LightOffCommand(Light()))
    button.press()
    button2.press()
}