package com.m3md69.registerandloginui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.m3md69.registerandloginui.view.LoginPage
import com.m3md69.registerandloginui.view.RegisterPage

class MainActivity : ComponentActivity() {

    companion object {
        const val LOGIN_PAGE = "LoginPage"
        const val REGISTER_PAGE = "RegisterPage"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NavigatePage() }
    }
}

@Composable
private fun NavigatePage() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MainActivity.LOGIN_PAGE
    ) {
        composable(route = MainActivity.LOGIN_PAGE, content = { LoginPage(navController = navController) })
        composable(route = MainActivity.REGISTER_PAGE, content = { RegisterPage(navController = navController) })
    }
}