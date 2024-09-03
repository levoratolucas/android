package com.example.myapplication

import android.media.Image
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableOpenTarget
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                // RightAlignedColunm()
                // WeighttedCenter()
                // SimpleBox(300)
                val lista = listOf(
                    Usuario(1,"Lucas Matheus Levorato Santos","41999113006"),
                    Usuario(2,"Lucas Matheus Levorato Santos","41999113006"),
                    Usuario(3,"Lucas Matheus Levorato Santos","41999113006"),
                    Usuario(4,"Lucas Matheus Levorato Santos","41999113006"),
                    Usuario(1,"Lucas Matheus Levorato Santos","41999113006"),
                    Usuario(2,"Lucas Matheus Levorato Santos","41999113006"),
                    Usuario(3,"Lucas Matheus Levorato Santos","41999113006"),
                    Usuario(4,"Lucas Matheus Levorato Santos","41999113006"),
                    Usuario(1,"Lucas Matheus Levorato Santos","41999113006"),
                    Usuario(2,"Lucas Matheus Levorato Santos","41999113006"),
                    Usuario(3,"Lucas tos","41999113006"),
                    Usuario(4,"Lucas Matheus Levorato Santos","41999113006"),
                    Usuario(1,"Lucas Matheus Levorato Santos","41999113006"),
                    Usuario(2,"Lucas Matheus Levorato Santos","41999113006"),
                    Usuario(3,"Lucas Matheus Levorato Santos","41999113006"),
                    Usuario(4,"Lucas Matheus ","41999113006")
                )


                   // MyCardExample("titulo","ksadugbaskdçvbasidvbasçidv asçkbasljvdaisidyv askçdbaskçdbasid \n iqewugqipeurgipewr",false)


                //ViewCards(lista)
                //Desafio(lista)
                val imag = painterResource(id = R.drawable.sexy)
                val tela = Tela("titulo do corinthians","mundial 2000,2012",imag)

                //Tela_exe02(tela = tela)
                CounterGame()



                   // Greeting(name = "lucas")
                }
            }
        }
    }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun RightAlignedColunm(){
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
        Text(text = "lucas")
        Text(text = "lucas")
        Row {
            Text(text = "lucas  ")
            Text(text = "lucas")
        }

    }
}
@Composable
fun SimpleBox( size: Int){
    Box(modifier = Modifier
        .size(size.dp)
        .background(Color.Green, shape = CircleShape)
        .border(1.dp, Color.Black, CircleShape)){
        Text(text = "ola mundo", modifier = Modifier.align(Alignment.TopEnd))
        Text(text = "ola mundo", modifier = Modifier.align(Alignment.BottomStart))
    }
}
@Composable

fun ViewCards(lista: List<Usuario>) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        items(lista){ U ->
            val isOddPosition = U.id % 2 != 0
            MyCardExample(U.nome.toString(),U.telefone,isOddPosition,buttonContent = { ColoredButton() }) }
    }

}
@Composable
fun MyCardExample(
    titulo : String,
    conteudo:String,
    color:Boolean,
    buttonContent: @Composable () -> Unit)
{
    Card(
        modifier = Modifier.padding(16.dp), //espaço ao redor do Card
        elevation = CardDefaults.cardElevation(4.dp),
        shape = RoundedCornerShape(8.dp)
    ){
        //Conteúdo do Card
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(color = Color.Transparent), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            buttonContent()
            if(color){
                Text(
                    text = titulo,
                    fontWeight = FontWeight.Bold,
                    color = Color.Red
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text =  conteudo,
                    color = Color.Red
                )
            }else{
                Text(text = titulo, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text =  conteudo)
            }

        }
    }
}

        data class Usuario(
    val id: Int,
    val nome: String,
    val telefone: String
)
@Composable
fun Desafio(lista : List<Usuario>) {

    val usuariosInfo = lista.map { usuario ->
        usuario
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(1f)) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Green)
            ){            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Red)
            ){            }
        }
        Row(modifier = Modifier.weight(1f)) {
            val usuario1 = usuariosInfo.filter {usuario ->  usuario.id==1 }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Yellow)
            )
            {
                Text(text = usuario1[0].id.toString(), modifier = Modifier.align(Alignment.Center), Color.Red)
            }
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(Color.Blue)
            ){            }
        }
    }
}

@Composable
fun WeighttedCenter(){
    Column(modifier = Modifier.fillMaxSize()){
        Text(text = "        ")
        Text(text = "lucas")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "***********")
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            horizontalArrangement = Arrangement.Absolute.Right
        ) {
            Text(text = "lucas")

        }



    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Lucas")

        Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = "lucas")
            Text(text = "lucas")
            Text(text = "lucas")
        }
    }
}

data class Tela(
    val titulo: String,
    val descricao: String,
    val image : Painter
)
@Composable
fun Tela_exe02(tela : Tela){
    Box(modifier = Modifier
        .fillMaxSize()

    ) {
        Image(
            painter = tela.image,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            //.background(Color.Yellow)
        ) {



            MyCardExample("titulo","ksadugbaskdçvbasidvbasçidv asçkbasljvdaisidyv askçdbaskçdbasid \n iqewugqipeurgipewr",false,buttonContent = { ColoredButton() })

        }
    }
}

@Composable
fun ColoredButton(){
    Button(onClick = { println("salve o corinthians") },
        //modifier = Modifier.background(color = Color.Red),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
        shape = RoundedCornerShape(8.dp)
    ) {

            Text(text = "botão")


    }
}
@Composable
fun BasicImage(){
    Image(
        painter = painterResource(id = R.drawable.sexy),
        contentDescription = "mulher sexy",
        modifier = Modifier
            .size(200.dp)
            .padding(16.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(2.dp, Color.Black)
    )
}

@Composable
fun Counter(){
    var count by remember { mutableIntStateOf(0) }
    var max = 100
    Image(
        painter = painterResource(id = R.drawable.image1),
        contentDescription = "mulher sexy",
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
        //.clip(RoundedCornerShape(12.dp))
        //.border(2.dp, Color.Black)
    )
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(text = "Contagem: $count",color = Color.Black )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {count++},
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = RoundedCornerShape(8.dp)) {
            Image(
                painter = painterResource(R.drawable.icons8_soma_24),
                contentDescription = null,
                Modifier.height(50.dp).width(100.dp)
            )
        }
        Button(onClick = {count--}) {
            Text(text = "Subtrai")
        }
    }

}
@Composable
fun CounterGame() {
    var count by remember { mutableIntStateOf(0) }
    val target = remember { (100..150).random() }
    var hasGivenUp by remember { mutableStateOf(false) } // State to track if the user has given up
    var gameEnded by remember { mutableStateOf(false) } // State to track if the game has ended

    // Determine which image to show based on the current count and if the user has given up
    val imageResource = when {
        hasGivenUp -> R.drawable.image5 // Show the "give up" image
        count >= target -> R.drawable.image4 // Show the final image if the target is reached
        count >= target * 2 / 3 -> R.drawable.image3
        count >= target / 3 -> R.drawable.image2
        else -> R.drawable.image1
    }
    Column(
        modifier = Modifier
            .fillMaxSize()){}

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween, // Space between items in the column
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
                    if (count >= target) gameEnded = true // End the game if target is reached
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                shape = RoundedCornerShape(8.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.icons8_soma_24),
                    contentDescription = null,
                    modifier = Modifier.height(50.dp).width(100.dp)
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
                        gameEnded = true // End the game if the user gives up
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
                        gameEnded = false // Reset the game state
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
