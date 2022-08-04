package com.sbery.weathy.presentation.main.view

import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.sbery.weathy.R
import com.sbery.weathy.presentation.screen.Screen

@Composable
fun WeathyBottomNavigation(navController: NavController) {
    val navItems = listOf(
        Screen.WeatherScreen,
        Screen.LocationScreen,
        Screen.SettingsScreen
    )

    BottomAppBar() {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        navItems.forEach { item ->
            val isSelected = currentRoute == item.route

            NavigationBarItem(
                icon = {
                    Icon(
                        painterResource(id = if (isSelected) item.selectedIcon else item.icon),
                        contentDescription = stringResource(item.title)
                    )
                },
                label = {
                    Text(
                        text = stringResource(item.title),
                        fontSize = 12.sp
                    )
                },
                alwaysShowLabel = true,
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}