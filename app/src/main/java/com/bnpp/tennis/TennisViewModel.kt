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

    fun getScore(): LiveData<String> {
        return gameScore
    }

    fun newGame() {
        tennisGame.newRound()
        gameScore.value = tennisGame.getScore()
    }

    fun addPlayer1Point(){
        tennisGame.playerOneScores()
        gameScore.value = tennisGame.getScore()
    }

}