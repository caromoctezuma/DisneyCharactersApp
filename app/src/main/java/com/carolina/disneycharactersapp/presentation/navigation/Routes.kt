package com.carolina.disneycharacters.presentation.navigation

sealed class Routes(val route: String) {
    data object Home : Routes("home")
    data object Favorites : Routes("favorites")
}