package com.example.ushtrimi_2.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ushtrimi_2.LoginRoute
import com.example.ushtrimi_2.SignUpRoute

@Composable
fun AppNavigation() {
    val navigationController = rememberNavController()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            navController = navigationController,
            startDestination = Routes.LOGIN
        ) {
            composable(Routes.LOGIN) {
                LoginRoute(
                    innerPadding = innerPadding,
                    onSignUpClick = { navigationController.navigate(Routes.SIGN_UP) }
                )
            }
            composable(Routes.SIGN_UP) {
                SignUpRoute(
                    innerPadding = innerPadding,
                    onBack = { navigationController.popBackStack() }
                )
            }
            composable(Routes.HOME) {}
            composable(Routes.GALLERY) {}
        }
    }
}

object Routes {
    const val LOGIN = "Login"
    const val SIGN_UP = "sign_up"
    const val HOME = "home"
    const val GALLERY = "gallery"
}
