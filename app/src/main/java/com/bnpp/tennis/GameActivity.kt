package com.bnpp.tennis

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameActivity : ComponentActivity() {

private val viewModel by viewModels<TennisViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TennisTheme {
                Surface(color = MaterialTheme.colors.background) {
                    TennisMainView(viewModel)
                }
            }
        }
    }
}

@Composable
fun TennisMainView(viewModel: TennisViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                }
            )
        }
    ) {
        ScoreView(viewModel)
    }
}

@Composable
fun ScoreView(viewModel: TennisViewModel) {
    val player1Point: String by viewModel.getPlayer1Point().observeAsState(String())

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
                            text = player1Point, style = Typography().h1)
                    }
                }
                Button(
                    modifier = Modifier.
                    testTag("player1AddButton"),
                    onClick = {
                        viewModel.addPlayer1Point()
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
            ScoreView(TennisViewModel(TennisGame()))
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