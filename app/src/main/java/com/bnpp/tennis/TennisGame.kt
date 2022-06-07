package com.bnpp.tennis

class TennisGame {

    var playerOneScore = 0
    var playerTwoScore = 0

    fun getScore(): String {
        return "$playerOneScore|$playerTwoScore"
    }

    fun playerOneScores() {
        playerOneScore += 15
    }

    fun playerTwoScores() {
        playerTwoScore += 15
    }
}
