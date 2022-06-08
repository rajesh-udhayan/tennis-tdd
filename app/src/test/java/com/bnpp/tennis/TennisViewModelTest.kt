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
}