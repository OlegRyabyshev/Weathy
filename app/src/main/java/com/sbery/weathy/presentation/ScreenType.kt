package com.sbery.weathy.presentation

sealed class ScreenType(val destination: String) {

    object SplashScreen : ScreenType("splash-screen")

    object ForecastScreen : ScreenType("forecast-screen")

    object SettingsScreen : ScreenType("settings-screen")

    object SearchScreen : ScreenType("search-screen")
}