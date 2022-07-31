package com.sbery.weathy.presentation.forecast.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sbery.weathy.presentation.ScreenType

@Composable
fun NavController(controller: NavHostController) {

    NavHost(
        navController = controller,
        startDestination = ScreenType.SplashScreen.destination
    ) {

        composable(ScreenType.SplashScreen.destination) {
            ForecastActivity()
        }
    }
}