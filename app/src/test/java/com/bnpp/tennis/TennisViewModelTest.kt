package com.bnpp.tennis

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule


class TennisViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    lateinit var tennisViewModel: TennisViewModel
    lateinit var gameSpy: TennisGame

    @Before
    fun setUp() {
        gameSpy = spyk()
        tennisViewModel = TennisViewModel(gameSpy)
    }

    @Test
    fun `should invoke newRound from TennisGame when newGame called`() {
        tennisViewModel.newGame()

        verify { gameSpy.newRound() }
    }

    @Test
    fun `should return 0 , 0 as score when getScore called`(){
        tennisViewModel.newGame()
        val score = tennisViewModel.getScore().getOrAwaitValue()

        assertThat(score).isEqualTo("0|0")
    }

    @Test
    fun `should return 15 , 0 as score when addPlayer1Point called`(){
        tennisViewModel.newGame()
        tennisViewModel.addPlayer1Point()
        val score = tennisViewModel.getScore().getOrAwaitValue()

        assertThat(score).isEqualTo("15|0")
    }

    @Test
    fun `should return 0 , 15 as score when addPlayer2Point called`(){
        tennisViewModel.newGame()
        tennisViewModel.addPlayer2Point()
        val score = tennisViewModel.getScore().getOrAwaitValue()

        assertThat(score).isEqualTo("0|15")
    }

    @Test
    fun `should invoke getPlayerOnePoints when player 1 scores`(){
        tennisViewModel.addPlayer1Point()

        verify { gameSpy.getPlayerOnePoints() }
    }

    @Test
    fun `should invoke getPlayerTwoPoints when player 2 scores`(){
        tennisViewModel.addPlayer2Point()

        verify { gameSpy.getPlayerTwoPoints() }
    }

    @Test
    fun `should return player points as 0 when new game started`(){
        tennisViewModel.newGame()

        assertThat(tennisViewModel.getPlayer1Point().getOrAwaitValue()).isEqualTo("0")
        assertThat(tennisViewModel.getPlayer2Point().getOrAwaitValue()).isEqualTo("0")
    }

    @Test
    fun `should invoke has winner when add score called for any player`(){
        tennisViewModel.addPlayer1Point()

        verify { gameSpy.hasWinner() }
    }

    @Test
    fun `should return false for has winner when new game started`(){
        tennisViewModel.addPlayer1Point()
        tennisViewModel.addPlayer1Point()
        tennisViewModel.addPlayer1Point()
        tennisViewModel.addPlayer1Point()
        tennisViewModel.newGame()

        assertThat(tennisViewModel.hasWinner().getOrAwaitValue()).isFalse()
    }
}