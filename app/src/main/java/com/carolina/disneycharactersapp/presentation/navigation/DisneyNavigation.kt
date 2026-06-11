package com.carolina.disneycharacters.presentation.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.carolina.disneycharacters.presentation.favorites.FavoritesScreen
import com.carolina.disneycharacters.presentation.home.HomeScreen

@Composable
fun DisneyNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = Routes.Home.route,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Routes.Home.route) {
                HomeScreen()
            }

            composable(Routes.Favorites.route) {
                FavoritesScreen()
            }
        }
    }
}