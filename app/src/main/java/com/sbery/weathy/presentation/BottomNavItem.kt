package com.sbery.weathy.presentation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sbery.weathy.R

sealed class BottomNavItem(
    @StringRes
    val title: Int? = null,
    @DrawableRes
    val icon: Int? = null,
    @StringRes
    val screenRoute: Int
) {

    object SplashScreen : BottomNavItem(
        screenRoute = R.string.splash_screen_destination
    )

    object WeatherScreen : BottomNavItem(
        R.string.weather_tab_name,
        R.drawable.ic_round_cloud_24,
        R.string.weather_screen_destination
    )

    object LocationScreen : BottomNavItem(
        R.string.location_tab_name,
        R.drawable.ic_round_location_24,
        R.string.location_screen_destination
    )

    object SettingsScreen : BottomNavItem(
        R.string.settings_tab_name,
        R.drawable.ic_round_settings_24,
        R.string.settings_screen_destination
    )
}