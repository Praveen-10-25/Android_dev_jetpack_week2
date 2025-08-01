package com.example.statehoisting.ui.theme

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyApp(){
    val navController= rememberNavController()
    NavHost(
        navController = navController, startDestination = "login",
    ){
        composable("login"){ Login_page(navController) }
        composable("signup") { SignUp_page(navController) }
        composable("home"){ Home_Page(navController) }
    }
    }