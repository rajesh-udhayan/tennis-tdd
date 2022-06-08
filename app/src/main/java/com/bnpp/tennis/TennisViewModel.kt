package com.bnpp.tennis

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TennisViewModel @Inject constructor(val tennisGame: TennisGame) : ViewModel() {

    fun newGame() {
        tennisGame.newRound()
    }

}