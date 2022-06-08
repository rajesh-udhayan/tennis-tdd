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
    fun shouldDisplayPlayer1Title() {
        with(composeTestRule) {
            val title = onNodeWithText("Player 1")

            title.assertIsDisplayed()
        }
    }

    @Test
    fun shouldDisplayPlayer1ScoreCard() {
        with(composeTestRule) {
            val card = onNodeWithTag("player1Card")
            val player1Score = onNodeWithTag("player1Score")

            card.assertIsDisplayed()
            player1Score.assertIsDisplayed()
        }
    }

    @Test
    fun shouldDisplayPlayer1AddPointButton() {
        with(composeTestRule) {
            val addButton = onNodeWithTag("player1AddButton")

            addButton.assertIsDisplayed()
        }
    }
}