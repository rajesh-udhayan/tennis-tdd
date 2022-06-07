package com.bnpp.tennis

class TennisGame {

    private var playerOneScore = 0
    private var playerTwoScore = 0

    fun getScore(): String {
        if (playerOneScore >= 4 && playerOneScore >= playerTwoScore+2){
            return "Player1 wins"
        }
        if (playerTwoScore >= 4 && playerTwoScore >= playerOneScore+2){
            return "Player2 wins"
        }
        return "${translateScore(playerOneScore)}|${translateScore(playerTwoScore)}"
    }

    fun playerOneScores() {
        playerOneScore++
    }

    fun playerTwoScores() {
        playerTwoScore++
    }

    fun translateScore(score: Int) : String {
        when(score) {
            0 -> return "0"
            1 -> return "15"
            2 -> return "30"
            3 -> return "40"
        }
        throw IllegalArgumentException("Invalid score : $score")
    }
}
