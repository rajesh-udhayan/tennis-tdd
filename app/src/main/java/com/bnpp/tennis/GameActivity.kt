package com.bnpp.tennis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TennisTheme {
                Surface(color = MaterialTheme.colors.background) {
                    TennisMainView()
                }
            }
        }
    }
}

@Composable
fun TennisMainView() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                }
            )
        }
    ) {
        ScoreView()
    }
}

@Composable
fun ScoreView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Player 1", style = Typography().h6)
                Card(
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = Color.LightGray,
                    modifier = Modifier
                        .padding(16.dp)
                        .width(120.dp)
                        .testTag("player1Card"),
                    elevation = 10.dp,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier
                                .testTag("player1Score"),
                            text = "0", style = Typography().h1)
                    }
                }
                Button(
                    modifier = Modifier.
                    testTag("player1AddButton"),
                    onClick = {

                }) {
                    Text(text = "Add point")
                }
            }
            Column(
                modifier = Modifier
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Player 2", style = Typography().h6)
                Card(
                    shape = RoundedCornerShape(8.dp),
                    backgroundColor = Color.LightGray,
                    modifier = Modifier
                        .padding(16.dp)
                        .width(120.dp)
                        .testTag("player2Card"),
                    elevation = 10.dp
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            modifier = Modifier.
                            testTag("player2Score"), text = "0", style = Typography().h1)
                    }
                }
                Button(
                    modifier = Modifier.
                    testTag("player2AddButton"),
                    onClick = {

                }) {
                    Text(text = "Add point")
                }
            }
        }
        Text(
            modifier = Modifier.testTag("scoreText"),
            text = "Score: ", style = Typography().h6
        )
    }
}

@Preview
@Composable
fun Preview(){
    TennisTheme {
        Surface(color = MaterialTheme.colors.background) {
            ScoreView()
        }
    }
}

@Composable
fun TennisTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = lightColors(),
        typography = Typography(),
        shapes = Shapes(),
        content = content
    )
}