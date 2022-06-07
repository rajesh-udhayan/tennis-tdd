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
        generateScore(1,1)

        assertThat(game.getScore()).isEqualTo("15|15")
    }

    @Test
    fun `should return 30, 0 when player one scores two times`() {
        generateScore(2)

        assertThat(game.getScore()).isEqualTo("30|0")
    }

    @Test
    fun `should return 0 , 40 when player two scores three times`(){
        generateScore(playerTwoPoints = 3)

        assertThat(game.getScore()).isEqualTo("0|40")
    }

    @Test
    fun `should return Player1 wins when player one scores more than 40`(){
        generateScore(4)

        assertThat(game.getScore()).isEqualTo("Player1 wins")
    }

    @Test
    fun `should return Player2 wins when player two scores more than 40`(){
        generateScore(playerTwoPoints = 4)

        assertThat(game.getScore()).isEqualTo("Player2 wins")
    }

    @Test
    fun `should return deuce when both players are 40 or more than 40`(){
        generateScore(4,4)

        assertThat(game.getScore()).isEqualTo("Deuce")
    }

    fun generateScore(playerOnePoints: Int = 0, playerTwoPoints: Int = 0){
        for (i in 1..playerOnePoints){
            game.playerOneScores()
        }
        for (i in 1..playerTwoPoints){
            game.playerTwoScores()
        }
    }
}