package com.sbery.weathy.presentation.screens

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sbery.weathy.R

sealed class Screen(
    @StringRes
    val title: Int,
    @DrawableRes
    val icon: Int,
    @DrawableRes
    val selectedIcon: Int,
    val route: String
) {
    object SplashScreen : Screen(
        EMPTY_RES,
        EMPTY_RES,
        EMPTY_RES,
        "weather_screen"
    )

    object WeatherScreen : Screen(
        R.string.weather_tab_name,
        R.drawable.ic_cloud_outlined_24,
        R.drawable.ic_cloud_filled_24,
        "weather_screen"
    )

    object LocationScreen : Screen(
        R.string.location_tab_name,
        R.drawable.ic_location_outlined_24,
        R.drawable.ic_location_filled_24,
        "location_screen"
    )

    object SettingsScreen : Screen(
        R.string.settings_tab_name,
        R.drawable.ic_settings_outlined_24,
        R.drawable.ic_settings_filled_24,
        "settings_screen"
    )

    private companion object {
        const val EMPTY_RES = 0
    }
}