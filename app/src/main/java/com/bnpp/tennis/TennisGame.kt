package com.bnpp.tennis

class TennisGame {

    private var playerOneScore = 0
    private var playerTwoScore = 0

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
