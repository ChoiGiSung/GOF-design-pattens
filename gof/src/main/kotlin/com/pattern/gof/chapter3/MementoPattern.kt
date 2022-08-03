package com.pattern.gof.chapter3

import java.time.Instant

class Game(
    private val redTeamScore: Int,
    private val blueTeamScore: Int
) {

    fun createCheckPoint(): CheckPoint {
        return CheckPoint(redTeamScore, blueTeamScore, Instant.now())
    }

    fun reload(checkPoint: CheckPoint): Game {
        return Game(checkPoint.redTeamScore, checkPoint.blueTeamScore)
    }

    fun showScore(){
        println(this.toString())
    }

    override fun toString(): String {
        return "Game(redTeamScore=$redTeamScore, blueTeamScore=$blueTeamScore)"
    }


}

class CheckPoint(
    val redTeamScore: Int,
    val blueTeamScore: Int,
    val createdTime: Instant
) {

}

class CareTaker {
    private val saveFile = mutableMapOf<Instant, CheckPoint>()

    fun save(checkPoint: CheckPoint) {
        saveFile[checkPoint.createdTime] = checkPoint
    }

    fun find(time: Instant) = saveFile[time]

    fun findFist(): CheckPoint = saveFile.firstNotNullOf { it.value }


}


fun main() {

    val careTaker = CareTaker()
    val game = Game(10, 20)

    val checkPoint = game.createCheckPoint()
    careTaker.save(checkPoint)

    val checkPoint2 = game.createCheckPoint()
    careTaker.save(checkPoint2)

    game.reload(careTaker.findFist())

    game.showScore()

}