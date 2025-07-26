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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Ligth(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Ligth(modifier: Modifier = Modifier) {
    // 🔁 This is a Compose state that remembers the light ON/OFF state
    var isLightOn by remember { mutableStateOf(false) }

    // 🎨 Change colors based on the state
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

            // 📝 Dynamic Text
            Text(
                text = if (isLightOn) "Light is ON" else "Light is OFF",
                color = textColor,
                style = MaterialTheme.typography.headlineLarge
            )

            Spacer(modifier = Modifier.height(24.dp))

            // 🔘 Toggle Switch (Compose version, not Android View)
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
