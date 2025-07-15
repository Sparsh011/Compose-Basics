package com.sparsh.composebasics.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

import androidx.compose.material.icons.outlined.*

sealed class MainScreen(
    val route: String,
    val label: String,
    val icon: ImageVector,
    val selectedIcon: ImageVector
) {
    data object Home : MainScreen("home", "Home", Icons.Outlined.Home, Icons.Filled.Home)
    data object Profile : MainScreen("profile", "Profile", Icons.Outlined.Person,
        Icons.Filled.Person)
}

val bottomNavItems = listOf(MainScreen.Home, MainScreen.Profile)