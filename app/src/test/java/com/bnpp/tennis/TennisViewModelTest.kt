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
}