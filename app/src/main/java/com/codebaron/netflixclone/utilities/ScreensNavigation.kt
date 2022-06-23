package com.codebaron.netflixclone.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.codebaron.netflixclone.utilities.Destinations.LOGIN_SCREEN
import com.codebaron.netflixclone.utilities.Destinations.SPLASH_SCREEN

@Composable
fun ScreenNavigation() {
    val navigationController = rememberNavController()
    NavHost(navController = navigationController,
        startDestination = SPLASH_SCREEN.name
    ) {
        composable(SPLASH_SCREEN.name) {
            SplashScreen(navigationController)
        }
        composable(LOGIN_SCREEN.name) {
            LoginScreen(navigationController)
        }
    }
}