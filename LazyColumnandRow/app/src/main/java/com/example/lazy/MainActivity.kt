package com.example.lazy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazy.ui.theme.LazyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LazyTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    Greeting(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    )
                    LazyColumnContent(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier.padding(8.dp),
        verticalAlignment = Alignment.Top,
    ) {
        items(10) { i ->
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription = "Profile Icon $i",
                modifier = Modifier
                    .size(70.dp)
            )
        }
    }
}

@Composable
fun LazyColumnContent(modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(8.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(10) { i ->
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "Star Icon $i",
                modifier = Modifier.size(70.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LazyTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            Greeting(modifier = Modifier.weight(1f))
            LazyColumnContent(modifier = Modifier.weight(1f))
        }
    }
}
