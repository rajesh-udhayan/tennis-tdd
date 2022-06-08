package com.bnpp.tennis

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TennisMainViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            TennisMainView()
        }
    }

    @Test
    fun shouldDisplayTennisText() {
        with(composeTestRule) {
            val title = onNodeWithText("Tennis")

            title.assertIsDisplayed()
        }
    }

    @Test
    fun shouldDisplayPlayer1ScoreView() {
        with(composeTestRule) {
            val title = onNodeWithText("Player 1")
            val card = onNodeWithTag("player1Card")
            val player1Score = onNodeWithTag("player1Score")
            val addButton = onNodeWithTag("player1AddButton")

            title.assertIsDisplayed()
            card.assertIsDisplayed()
            player1Score.assertIsDisplayed()
            addButton.assertIsDisplayed()
        }
    }

    @Test
    fun shouldDisplayPlayer2ScoreView() {
        with(composeTestRule) {
            val title = onNodeWithText("Player 2")
            val card = onNodeWithTag("player2Card")
            val player2Score = onNodeWithTag("player2Score")
            val addButton = onNodeWithTag("player2AddButton")

            title.assertIsDisplayed()
            card.assertIsDisplayed()
            player2Score.assertIsDisplayed()
            addButton.assertIsDisplayed()
        }
    }

    @Test
    fun shouldDisplayScoreTest() {
        with(composeTestRule){
            val score = onNodeWithTag("scoreText")

            score.assertIsDisplayed()
        }
    }

}