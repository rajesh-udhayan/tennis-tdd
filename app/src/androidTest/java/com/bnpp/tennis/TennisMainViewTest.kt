package com.bnpp.tennis

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TennisMainViewTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            TennisMainView(TennisViewModel(TennisGame()))
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
            addButton.assertIsEnabled()
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
            addButton.assertIsEnabled()
        }
    }

    @Test
    fun shouldDisplayScoreTest() {
        with(composeTestRule) {
            val score = onNodeWithTag("scoreText")

            score.assertIsDisplayed()
        }
    }

    @Test
    fun shouldDisplayPlayer1PointWhenScored() {
        with(composeTestRule) {
            val addButton = onNodeWithTag("player1AddButton")
            val player1Score = onNodeWithTag("player1Score")

            addButton.performClick()
            player1Score.assertTextEquals("15")
        }
    }

    @Test
    fun shouldDisplayPlayer2PointWhenScored() {
        with(composeTestRule) {
            val addButton = onNodeWithTag("player2AddButton")
            val player2Score = onNodeWithTag("player2Score")

            addButton.performClick()
            player2Score.assertTextEquals("15")
        }
    }

    @Test
    fun shouldDisplayResultTextWhenNewGameStarted() {
        with(composeTestRule) {
            val score = onNodeWithTag("scoreText")

            score.assertTextEquals("Result: 0|0")
        }
    }

    @Test
    fun shouldDisableAddPointsButtonAfterAnyoneWins() {
        with(composeTestRule) {
            val addPoint1 = onNodeWithTag("player1AddButton")
            val addPoint2 = onNodeWithTag("player2AddButton")

            addPoint1.performClick()
            addPoint1.performClick()
            addPoint1.performClick()
            addPoint1.performClick()

            addPoint1.assertIsNotEnabled()
            addPoint2.assertIsNotEnabled()
        }
    }

    @Test
    fun shouldDisplayNewGameButtonAfterAnyoneWins() {
        with(composeTestRule) {
            val addPoint1 = onNodeWithTag("player1AddButton")
            val newGame = onNodeWithTag("newGame")

            addPoint1.performClick()
            addPoint1.performClick()
            addPoint1.performClick()
            addPoint1.performClick()

            newGame.assertIsDisplayed()
            newGame.assertIsEnabled()
        }
    }

    @Test
    fun shouldEnableAddPointButtonsAndHideNewGameButtonWhenNewGameStarted() {
        with(composeTestRule) {
            val addPoint1 = onNodeWithTag("player1AddButton")
            val addPoint2 = onNodeWithTag("player2AddButton")
            val newGame = onNodeWithTag("newGame")

            addPoint1.performClick()
            addPoint1.performClick()
            addPoint1.performClick()
            addPoint1.performClick()

            newGame.performClick()

            addPoint1.assertIsEnabled()
            addPoint2.assertIsEnabled()
            newGame.assertDoesNotExist()
        }
    }
}