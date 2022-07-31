package com.sbery.weathy.presentation.forecast.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sbery.weathy.presentation.BottomNavItem
import com.sbery.weathy.presentation.splashscreen.SplashScreen

@Composable
fun NavController(controller: NavHostController) {
    val context = LocalContext.current

    NavHost(
        navController = controller,
        startDestination = context.getString(BottomNavItem.SplashScreen.screenRoute)
    ) {

        composable(context.getString(BottomNavItem.SplashScreen.screenRoute)) {
            SplashScreen()
        }
    }
}