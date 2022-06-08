package com.bnpp.tennis

import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import org.junit.Before
import org.junit.Test


class TennisViewModelTest {


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
}