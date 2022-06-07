package com.bnpp.tennis

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class TennisGameTest {

    @Test
    fun `should return 0 , 0 as score when new game started`(){
        val game = TennisGame()

        assertThat(game.getScore()).isEqualTo("0|0")
    }
}