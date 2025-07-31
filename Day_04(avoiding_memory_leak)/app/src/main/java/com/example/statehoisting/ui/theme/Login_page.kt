package com.example.statehoisting.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.example.statehoisting.Viewmodel.SignupViewModel


@Composable
fun Login_page(
    navController: NavController,
    viewModel: SignupViewModel = viewModel()
) {
    val email by viewModel.email.observeAsState("")
    val password by viewModel.password.observeAsState("")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login Page",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(25.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { viewModel.onUpdateEmail(it) },
            label = { Text("Enter Email") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = { viewModel.onUpdatepass(it) },
            label = { Text("Enter Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("signup")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Go to Signup")
        }
    }
}
