package com.dwh.kosmos.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dwh.kosmos.presentation.ui.CharactersScreen

@Composable
fun Navigation(navController: NavController) {
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screens.WELCOME
    ) {
        // Pantalla inicial
        composable(Screens.WELCOME) {
            CharactersScreen(navController)
        }
    }
}
