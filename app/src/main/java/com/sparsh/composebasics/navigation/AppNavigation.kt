package com.sparsh.composebasics.navigation

import androidx.compose.animation.ContentTransform
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.sparsh.composebasics.screens.home.HomeScreen

@Composable
fun AppNavigation() {
    val backStack = remember { mutableStateListOf<MainScreen>(MainScreen.Home) }
    val currentScreen = backStack.last()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                currentScreen = currentScreen,
                onBottomBarItemClick = { screen ->
                    if (currentScreen != screen) {
                        backStack.add(screen)
                    }
                },
            )
        },
    ) { padding ->
        NavDisplay(
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            transitionSpec = {
                ContentTransform(
                    targetContentEnter = slideInHorizontally { -it } + scaleIn(initialScale = 0.98f),
                    initialContentExit = slideOutHorizontally { -it } + scaleOut(targetScale = 0.98f)
                )
            },
            entryProvider = { key ->
                when (key) {
                    is MainScreen.Home -> NavEntry(key) {
                        HomeScreen()
                    }

                    is MainScreen.Profile -> NavEntry(key) {

                    }
                }
            },
        )
    }
}