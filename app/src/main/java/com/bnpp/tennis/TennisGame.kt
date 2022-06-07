package com.bnpp.tennis

class TennisGame {

    var playerOneScore = 0

    fun getScore(): String {
        return "$playerOneScore|0"
    }

    fun playerOneScores() {
        playerOneScore++
    }
}
