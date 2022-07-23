package com.pattern.gof.chapter2

interface GameService{
    fun startGame()
}

class DefaultGameService():GameService{
    override fun startGame() {
        println("게임실행")
    }
}

class ProxyGameService(
    private val gameService: GameService
):GameService{
    override fun startGame() {
        //do something
        gameService.startGame()
    }

}
