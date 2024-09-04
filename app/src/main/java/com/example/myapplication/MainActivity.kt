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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
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
    val target = rememberSaveable { (20..40).random() }
    var hasGivenUp by rememberSaveable { mutableStateOf(false) }
    var gameEnded by rememberSaveable { mutableStateOf(false) }

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


        if (!gameEnded) {
            Button(
                onClick = {
                    count++
                    if (count >= target) gameEnded = true
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
                        count = 0
                        hasGivenUp = false
                        gameEnded = false
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
