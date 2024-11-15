package com.example.ud08_1_compose
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ud08_1_compose.ui.theme.UD08_1_ComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UD08_1_ComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    myApp(Modifier.padding(innerPadding))

                }
            }
        }
    }
}
@Composable
fun myApp(modifier: Modifier){
    Greeting(listOf("Sabela", "Pepe"), modifier)

}

// Quiere decir que va a utilizar compose que, en este caso, define un texto
@Composable
fun Greeting(names: List<String>, modifier: Modifier = Modifier) {
    // funcion similar a EditText, modifier aplica estilos
    Surface (color = MaterialTheme.colorScheme.primary){

        Column (modifier= Modifier
            .fillMaxSize()
            .padding(14.dp)){
            for(name in names){
                Text(
                    text= "Hello $name"
                )
                ElevatedButton(onClick = { }) {
                    Text(text = "Show more")
                }
            }
        }


    }

        /*  Row {

              Text(
              text = stringResource(id = R.string.hello).plus(System.lineSeparator()).plus(name),
              //text = "Hello $name!",
              modifier = modifier
                  .padding(15.dp)
                  .size(150.dp),
              fontStyle = FontStyle.Italic,
              fontWeight = FontWeight.Bold,
              color = colorResource(id = R.color.purple_200),
              style = TextStyle(
                  fontSize = 30.sp,
                  shadow = Shadow(
                      color = Color.Black,
                      offset = Offset(5.0f, 10.0f)
                  )
              )
          )
          Text(
              text = stringResource(id = R.string.text),
              modifier = modifier
                  .padding(15.dp)
                  .size(100.dp)
              ,
              style = TextStyle(
                  brush = Brush.linearGradient(listOf(Color.Cyan, Color.Yellow))
              )
              ,
              textAlign = TextAlign.Center
          )

      }
      }*/
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UD08_1_ComposeTheme {
        myApp(modifier = Modifier.fillMaxSize())
    }
}