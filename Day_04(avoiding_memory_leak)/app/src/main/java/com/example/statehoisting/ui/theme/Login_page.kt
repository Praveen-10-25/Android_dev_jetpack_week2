package com.example.statehoisting.ui.theme

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.statehoisting.Viewmodel.SignupViewModel

@Composable
fun Login_page(
    navController: NavController,
    viewModel: SignupViewModel = viewModel()
) {
    val context = LocalContext.current
    val sharedPref = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)


    val email by viewModel.email.observeAsState("")
    val password by viewModel.password.observeAsState("")

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            shape = MaterialTheme.shapes.medium
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Login Page",
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(bottom = 24.dp)
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

                Spacer(modifier = Modifier.height(24.dp))


                Button(
                    onClick ={
                        val savedEmail = sharedPref.getString("email", "") ?: ""
                        val savedPassword = sharedPref.getString("password", "") ?: ""

                        if (email == savedEmail && password == savedPassword) {
                            Toast.makeText(context, "Login successful!", Toast.LENGTH_SHORT ).show()
                            navController.navigate("home")
                        } else {
                            Toast.makeText(context, "You need To Signup ", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text("Login")
                }

                Spacer(Modifier.height(24.dp))
                Button(
                    onClick = {
                        navController.navigate("signup")
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Signup")
                }
            }
        }
    }
}
