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
    fun `should return 15 , 0 when player one scores`(){
        game.playerOneScores()

        assertThat(game.getScore()).isEqualTo("15|0")
    }

    @Test
    fun `should return 0 , 15 when player two scores`(){
        game.playerTwoScores()

        assertThat(game.getScore()).isEqualTo("0|15")
    }

    @Test
    fun `should return 15 , 15 when both player scores`(){
        game.playerOneScores()
        game.playerTwoScores()

        assertThat(game.getScore()).isEqualTo("15|15")
    }

    @Test
    fun `should return 30, 0 when player one scores two times`() {
        game.playerOneScores()
        game.playerOneScores()

        assertThat(game.getScore()).isEqualTo("30|0")
    }

    @Test
    fun `should return 0 , 40 when player two scores three times`(){
        game.playerTwoScores()
        game.playerTwoScores()
        game.playerTwoScores()

        assertThat(game.getScore()).isEqualTo("0|40")
    }

    @Test
    fun `should return Player1 wins when player one scores more than 40`(){
        game.playerOneScores()
        game.playerOneScores()
        game.playerOneScores()
        game.playerOneScores()
        game.playerOneScores()

        assertThat(game.getScore()).isEqualTo("Player1 wins")
    }
}