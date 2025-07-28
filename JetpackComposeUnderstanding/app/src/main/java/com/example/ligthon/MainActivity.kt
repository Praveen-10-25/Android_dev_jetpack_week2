package com.example.ligthon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ligthon.ui.theme.LigthOnTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LigthOnTheme {
                    Ligth(modifier = Modifier.padding(35.dp))
            }
        }
    }
}

@Composable
fun Ligth(modifier: Modifier = Modifier) {
    var isLightOn by remember { mutableStateOf(false) }

    val backgroundColor = if (isLightOn) Color.White else Color.Black
    val textColor = if (isLightOn) Color.Black else Color.White

    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = backgroundColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = if (isLightOn) "Light is ON" else "Light is OFF",
                color = textColor,
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(24.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Toggle Light",
                    color = textColor,
                    modifier = Modifier.padding(end = 8.dp)
                )
                Switch(
                    checked = isLightOn,
                    onCheckedChange = { isLightOn = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Yellow,
                        uncheckedThumbColor = Color.Gray
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LightPreview() {
    LigthOnTheme {
        Ligth()
    }
}
