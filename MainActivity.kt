package com.example.tarea_1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tarea_1.ui.theme.Tarea_1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Greeting(
                    name = "LOGIN"
                )
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var contexto = LocalContext.current

    Image(
        painter = painterResource(id = R.drawable.calculadora),
        contentDescription = "logo",
        modifier =Modifier
            .padding(16.dp)
            .fillMaxWidth()
    )

    Text(
        text = "$name!!",
        modifier = modifier
    )

    Spacer(modifier = Modifier.padding(10.dp))

    StyledTextField()
}

fun validarPassword(password: String): Boolean{
    val regex = Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*_).{8,}$")
    return regex.matches(password)
}

@Composable
fun StyledTextField() {

    var contexto = LocalContext.current

    var value1 by remember { mutableStateOf("Pepito123") }           //usuario
    var password by rememberSaveable { mutableStateOf("") }     //clave

    TextField(
        value = value1,
        onValueChange = { value1 = it },
        label = { Text("Ingrese nombre de usuario") },
        maxLines = 2,
        textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(20.dp)
    )

    Spacer(modifier = Modifier.padding(top = 5.dp, bottom = 5.dp))

    TextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Ingrese la Contraseña") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )

    Spacer(modifier = Modifier.padding(top = 5.dp, bottom = 35.dp))

    Button(
        onClick = {
            if (value1 == "Kazim08" && password == "Khjm123_") {
                val intent = Intent(contexto, MainActivity2::class.java)
                intent.putExtra("firstKeyName", value1);
                contexto.startActivity(intent)
            } else Toast.makeText(contexto, "Usuario o Contraseña Invalida", Toast.LENGTH_LONG).show()
        }
    ) {
        Text(
            text = "Ingresar"
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Greeting(
            name = "LOGIN"
        )
    }
}