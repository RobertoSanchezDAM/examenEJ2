package com.example.robertosanchez.examenej2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.robertosanchez.examenej2.ui.theme.ExamenEJ2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            ExamenEJ2Theme {
                ColorSelectorApp()
            }
        }
    }
}

@Composable
fun ColorSelectorApp() {
    val colorSeleccionado = remember { mutableStateOf(Color.Gray) }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Colores a seleccionar:", fontSize = 25.sp)

        listaColores(colorSeleccionado = colorSeleccionado.value,
            onColorSeleccionado = { colorSeleccionado.value = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier.fillMaxWidth()
                .background(colorSeleccionado.value)
                .height(100.dp),
        ) {
            Text(
                text = "Color seleccionado",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun listaColores(colorSeleccionado: Color, onColorSeleccionado: (Color) -> Unit) {
    val colores = listOf(Color.Red, Color.Green, Color.Blue, Color.Yellow)

    Row {
        for (color in colores) {
            ColorItem(color = color, estaSeleccionado = color == colorSeleccionado, onClick = { onColorSeleccionado(color) })
        }
    }
}

@Composable
fun ColorItem(color: Color, estaSeleccionado: Boolean, onClick: () -> Unit) {
    Row(
        modifier = Modifier.width(95.dp)
            .padding(4.dp)
            .background(color)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = if (estaSeleccionado) "Selec." else "",
            modifier = Modifier.padding(8.dp)
        )
    }
}
