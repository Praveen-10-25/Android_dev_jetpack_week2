package com.example.statehoisting.ui.theme

import android.util.Patterns
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.statehoisting.Viewmodel.SignupViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SignUp_page(
    navController: NavController,
    signupViewModel: SignupViewModel = viewModel()
)
 {
    val context = LocalContext.current

    val name by signupViewModel.name.observeAsState("")
    val email by signupViewModel.email.observeAsState("")
    val password by signupViewModel.password.observeAsState("")
    val confirmPass by signupViewModel.confirmpass.observeAsState("")

    var emailError by remember { mutableStateOf(false) }
    var confirmPassError by remember { mutableStateOf(false) }
    var formError by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { signupViewModel.onUpdatename(it) },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {
                signupViewModel.onUpdateEmail(it)
                emailError = false
            },
            isError = emailError,
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        if (emailError) {
            Text("Enter a valid email", color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { signupViewModel.onUpdatepass(it) },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = confirmPass,
            onValueChange = {
                signupViewModel.onConfirmPass(it)
                confirmPassError = false
            },
            isError = confirmPassError,
            label = { Text("Confirm Password") },
            modifier = Modifier.fillMaxWidth()
        )
        if (confirmPassError) {
            Text("Passwords do not match", color = MaterialTheme.colorScheme.error)
        }

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                emailError = !Patterns.EMAIL_ADDRESS.matcher(email).matches()
                confirmPassError = password != confirmPass

                if (name.isBlank() || email.isBlank() || password.isBlank() || confirmPass.isBlank()) {
                    formError = "All fields are required"
                } else if (!emailError && !confirmPassError) {
                    formError = ""
                    navController.navigate("login")
                    Toast.makeText(context, "Signup successful!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sign Up")
        }

        if (formError.isNotEmpty()) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(formError, color = MaterialTheme.colorScheme.error)
        }
    }
}
