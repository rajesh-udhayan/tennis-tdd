package com.bnpp.tennis

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
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
}