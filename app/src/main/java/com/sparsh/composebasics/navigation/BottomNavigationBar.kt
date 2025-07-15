package com.sparsh.composebasics.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BottomNavigationBar(
    currentScreen: MainScreen,
    onBottomBarItemClick: (MainScreen) -> Unit
) {
    NavigationBar(
        containerColor = Color.Transparent
    ) {
        for (screen in bottomNavItems) {
            NavigationBarItem(
                selected = currentScreen == screen,
                onClick = {
                    onBottomBarItemClick(screen)
                },
                icon = {
                    Icon(screen.icon, contentDescription = null)
                },
                label = {
                    Text(
                        screen.label, color = if (currentScreen == screen) Color.White else
                            Color.LightGray.copy(alpha = 0.8f)
                    )
                }
            )
        }
    }
}