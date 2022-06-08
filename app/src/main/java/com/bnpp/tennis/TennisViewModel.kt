package com.bnpp.tennis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TennisViewModel @Inject constructor(val tennisGame: TennisGame) : ViewModel() {

    private val gameScore: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    private val player1Point: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    private val player2Point: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }
    private val hasWinner: MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }

    fun getScore(): LiveData<String> {
        return gameScore
    }

    fun getPlayer1Point(): LiveData<String> {
        return player1Point
    }

    fun getPlayer2Point(): LiveData<String> {
        return player2Point
    }

    fun hasWinner(): LiveData<Boolean> {
        return hasWinner
    }

    fun newGame() {
        tennisGame.newRound()
        gameScore.value = tennisGame.getScore()
        player1Point.value = tennisGame.getPlayerOnePoints()
        player2Point.value = tennisGame.getPlayerTwoPoints()
        hasWinner.value = tennisGame.hasWinner()
    }

    fun addPlayer1Point(){
        tennisGame.playerOneScores()
        gameScore.value = tennisGame.getScore()
        player1Point.value = tennisGame.getPlayerOnePoints()
        hasWinner.value = tennisGame.hasWinner()
    }


    fun addPlayer2Point(){
        tennisGame.playerTwoScores()
        gameScore.value = tennisGame.getScore()
        player2Point.value = tennisGame.getPlayerTwoPoints()
        hasWinner.value = tennisGame.hasWinner()
    }
}