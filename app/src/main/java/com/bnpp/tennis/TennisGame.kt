package com.bnpp.tennis

import javax.inject.Inject

class TennisGame @Inject constructor(){

    private var playerOneScore = 0
    private var playerTwoScore = 0

    fun newRound(){
        playerOneScore = 0
        playerTwoScore = 0
    }

    fun getScore(): String {
        if (playerOneScore >= 4 && playerOneScore >= playerTwoScore+2){
            return "Player1 wins"
        }
        if (playerTwoScore >= 4 && playerTwoScore >= playerOneScore+2){
            return "Player2 wins"
        }
        if (playerOneScore >= 3 && playerOneScore == playerTwoScore){
            return "Deuce"
        }
        if (playerTwoScore >= 4 && playerTwoScore == playerOneScore + 1){
            return "Advantage Player2"
        }
        if (playerOneScore >= 4 && playerOneScore == playerTwoScore + 1){
            return "Advantage Player1"
        }
        return "${translateScore(playerOneScore)}|${translateScore(playerTwoScore)}"
    }

    fun hasWinner(): Boolean{
        if (playerOneScore >= 4 && playerOneScore >= playerTwoScore+2
            || playerTwoScore >= 4 && playerTwoScore >= playerOneScore+2){
            return true
        }
        return false
    }

    fun playerOneScores() {
        playerOneScore++
    }

    fun playerTwoScores() {
        playerTwoScore++
    }

    fun getPlayerOnePoints(): String{
        return if (playerOneScore<= 3){
            translateScore(playerOneScore)
        } else {
            "40"
        }
    }

    fun getPlayerTwoPoints(): String{
        return if (playerTwoScore<= 3){
            translateScore(playerTwoScore)
        } else {
            "40"
        }
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
