package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                CounterGame()
            }
        }
    }
}
@Composable
fun CounterGame() {
    var count by rememberSaveable { mutableIntStateOf(0) }
    var target by rememberSaveable { mutableStateOf((1..50).random()) }
    var hasGivenUp by rememberSaveable { mutableStateOf(false) }
    var gameEnded by rememberSaveable { mutableStateOf(false) }
    var showCongratulations by rememberSaveable { mutableStateOf(false) }
    var showGiveUpDialog by rememberSaveable { mutableStateOf(false) }

    fun resetGame() {
        count = 0
        hasGivenUp = false
        gameEnded = false
        showCongratulations = false
        showGiveUpDialog = false
        target = (1..50).random() // Novo número aleatório
    }

    val imageResource = when {
        hasGivenUp -> R.drawable.image5
        count >= target -> R.drawable.image4
        count >= target * 2 / 3 -> R.drawable.image3
        count >= target / 3 -> R.drawable.image2
        else -> R.drawable.image1
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = imageResource),
            contentDescription = "Image progression",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        )

        if (showCongratulations) {
            AlertDialog(
                onDismissRequest = { showCongratulations = false },
                title = { Text(text = "Parabéns!") },
                text = { Text(text = "Você atingiu a meta de $target cliques!") },
                confirmButton = {
                    Button(onClick = {
                        resetGame()
                    }) {
                        Text("Novo Jogo")
                    }
                }
            )
        }

        if (showGiveUpDialog) {
            AlertDialog(
                onDismissRequest = { showGiveUpDialog = false },
                title = { Text(text = "Você desistiu!") },
                text = { Text(text = "Deseja iniciar um novo jogo?") },
                confirmButton = {
                    Button(onClick = {
                        resetGame()
                    }) {
                        Text("Sim")
                    }
                },
                dismissButton = {
                    Button(onClick = { showGiveUpDialog = false }) {
                        Text("Não")
                    }
                }
            )
        }

        if (!gameEnded) {
            Button(
                onClick = {
                    count++
                    if (count >= target) {
                        gameEnded = true
                        showCongratulations = true
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                shape = RoundedCornerShape(8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.icons8_soma_24),
                    contentDescription = null,
                    modifier = Modifier
                        .height(50.dp)
                        .width(100.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            if (!gameEnded) {
                Button(
                    onClick = {
                        hasGivenUp = true
                        gameEnded = true
                        showGiveUpDialog = true
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Desistir", color = Color.White)
                }
            }

            if (gameEnded) {
                Button(
                    onClick = {
                        resetGame()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(text = "Reiniciar", color = Color.White)
                }
            }
        }
    }
}
