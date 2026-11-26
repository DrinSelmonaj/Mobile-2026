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
import com.example.ushtrimi_2.home.contacts.HomeScreen
import com.example.ushtrimi_2.home.gallery.GalleryScreen

@Composable
fun AppNavigation() {
    val navigationController = rememberNavController()

    NavHost(
        navController = navigationController,
        startDestination = Routes.LOGIN,
    ) {
        composable(Routes.LOGIN) {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                LoginRoute(
                    innerPadding = innerPadding,
                    onLoginSuccessfully = {
                        navigationController.navigate(Routes.HOME) {
                            popUpTo(Routes.LOGIN) {
                                inclusive = true
                            }
                        }
                    },
                    onSignUpClick = { navigationController.navigate(Routes.SIGN_UP) }
                )
            }
        }
        composable(Routes.SIGN_UP) {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                SignUpRoute(
                    innerPadding = innerPadding,
                    onBack = { navigationController.popBackStack() }
                )
            }
        }
        composable(Routes.HOME) {
            HomeScreen() {
                navigationController.navigate(Routes.GALLERY)
            }
        }
        composable(Routes.GALLERY) {
            GalleryScreen(
                onGalleryItemClicked = {
                    //define new fullscreen with share options or whatever we can
                    //do with gallery item
                    //FullScreenGalleryItem()
                },
                onBack = {
                    navigationController.navigate(Routes.HOME)
                }
            )
        }
    }
}

object Routes {
    const val LOGIN = "login"
    const val SIGN_UP = "sign_up"
    const val HOME = "home"
    const val GALLERY = "gallery"
    // other screen routes
}
