package com.example.ligthon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ligthon.ui.theme.LigthOnTheme
import androidx.compose.ui.graphics.Color


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

@Composable
fun Ligth(modifier: Modifier=Modifier) {
    var islightOn by remember {
        mutableStateOf(false)
    }
    val backgroundColor = if (islightOn) Color.White else Color.Black
    val textcolor = if (islightOn) Color.Black else Color.White
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = backgroundColor
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp)
        ) {
            Text(
                text = if (islightOn) "Light is on" else "light is off",
                style = MaterialTheme.typography.headlineLarge,
                color = textcolor
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(onClick = { islightOn = !islightOn }) {
                Text(text = if (islightOn) "Turn Off" else " Turn On")
            }
        }
    }
}
    @Preview(showBackground = true)
    @Composable
    fun LightPreview(){
        LigthOnTheme {
            Ligth()
        }
    }
}