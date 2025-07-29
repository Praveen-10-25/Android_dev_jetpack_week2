package com.example.day02_ui_states

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@JvmOverloads
@Composable
fun LoginScreen(viewModel:LoginViewModel= viewModel()) {

 val loginstate by viewModel.loginstate.collectAsState()

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
       OutlinedTextField(
           value = username,
           onValueChange = {username = it},
           label = {Text("Username")},
           modifier = Modifier.fillMaxWidth()
       )
        Spacer(modifier = Modifier.height(24.dp))
        OutlinedTextField(
            value=password,
            onValueChange = {password = it},
            label={Text("Password")},
            modifier =Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {viewModel.login(username,password)}, modifier = Modifier.fillMaxWidth(), enabled = loginstate !is loginUiState.Loading
        ) {
            Text(text = "Login")
        }
        Spacer(modifier = Modifier.height(24.dp))

        when(loginstate){
            is loginUiState.Loading->{
                CircularProgressIndicator()
            }
            is loginUiState.Success->{
                Text("Login SuccessFully ,", color = MaterialTheme.colorScheme.primary)
            }is loginUiState.Error->{
                Text(
                    text=(loginstate as loginUiState.Error).message,
                    color=MaterialTheme.colorScheme.error
                )
            }else->{}
        }
    }
}