package com.example.tarea_1

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tarea_1.ui.theme.Tarea_1Theme

class MainActivity2 : ComponentActivity() {

    var firstKeyName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val myIntent = intent
            firstKeyName = myIntent.getStringExtra("firstKeyName")

            Tarea_1Theme {
                Scaffold (
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ){innerPadding ->
                    Greeting2(
                        name = firstKeyName.toString(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@SuppressLint("ContextCastToActivity")
@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    var contexto = LocalContext.current
    val activity = (LocalContext.current as? Activity)

    var value1 by remember { mutableStateOf("") }
    var value2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Calculadora",
            modifier = modifier
        )
        Text(
            text = "Bienvenida $name!",
            modifier = modifier
        )

        TextField(
            value = value1,
            onValueChange = {
                if(it.all { char -> char.isDigit() })
                    value1 = it},
            label = { Text("Ingresa un numero") },
            textStyle = TextStyle(color = Color.Yellow, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(20.dp)
        )

        Spacer(modifier = Modifier.padding(bottom = 1.dp))

        TextField(
            value = value2,
            onValueChange = {if(it.all { char -> char.isDigit() })
                value2 = it},
            label = { Text("Ingrese un numero") },
            textStyle = TextStyle(color = Color.Yellow, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(20.dp)
        )

        Spacer(modifier = Modifier.padding(5.dp))

        Row (
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    val n1 = value1.toIntOrNull()
                    val n2 = value2.toIntOrNull()

                    resultado = if (n1 != null && n2 != null) {
                        (n1 + n2).toString()
                    } else ""
                    Toast.makeText(contexto,"Valores incompletos",Toast.LENGTH_LONG).show()
                },
                modifier = Modifier
                    .width(130.dp)
            ) {
                Text(
                    text = "Suma"
                )
            }

            Button(
                onClick = {
                    val n1 = value1.toIntOrNull()
                    val n2 = value2.toIntOrNull()

                    resultado = if (n1 != null && n2 != null) {
                        (n1 - n2).toString()
                    } else ""
                    Toast.makeText(contexto,"Valores incompletos",Toast.LENGTH_LONG).show()
                },
                modifier = Modifier
                    .width(130.dp)
            ) {
                Text(
                    text = "Resta"
                )
            }
        }

        Spacer(modifier = Modifier.padding(15.dp))

        Row (
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {

        Button(
            onClick = {
                val n1 = value1.toIntOrNull()
                val n2 = value2.toIntOrNull()

                resultado = if(n1 != null && n2 != null){
                    (n1 * n2).toString()
                }else ""
                Toast.makeText(contexto,"Valores incompletos",Toast.LENGTH_LONG).show()
            }
        ) {
            Text(
                text = "Multiplicacion"
            )
        }

        Button(
            onClick = {
                val n1 = value1.toIntOrNull()
                val n2 = value2.toIntOrNull()
                val float1 = n1?.toFloat()
                val float2 = n2?.toFloat()

                resultado = if(float1 != null && float2 != null){
                    (n1 / n2).toString()
                }else ""
                Toast.makeText(contexto,"Valores incompletos",Toast.LENGTH_LONG).show()
            },
            modifier = Modifier
                .width(130.dp)
        ) {
            Text(
                text = "Division"
            )
        }
            }

        Spacer(modifier = Modifier.padding(10.dp))

        TextField(
            value = resultado,
            onValueChange = {},
            readOnly = true,
            label = { Text("Resultado") },
            textStyle = TextStyle(color = Color.Green, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(20.dp)
        )

        Spacer(modifier = Modifier.padding(10.dp))

        Button(
            onClick = {
                activity?.finish()
            }
        ) {
            Text(
                text = "Salir"
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview2() {
    Tarea_1Theme {
        Greeting2("Android")
    }
}