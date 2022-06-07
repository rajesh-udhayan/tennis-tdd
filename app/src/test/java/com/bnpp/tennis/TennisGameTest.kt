package com.bnpp.tennis

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class TennisGameTest {

    private lateinit var game: TennisGame

    @Before
    fun setUp(){
         game = TennisGame()
    }

    @Test
    fun `should return 0 , 0 as score when new game started`(){
        assertThat(game.getScore()).isEqualTo("0|0")
    }

    @Test
    fun `should return 1 , 0 when player one scores`(){
        game.playerOneScores()

        assertThat(game.getScore()).isEqualTo("1|0")
    }
}