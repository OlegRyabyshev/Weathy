@file:OptIn(ExperimentalMaterial3Api::class)

package com.sbery.weathy.presentation.main.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sbery.weathy.presentation.ui.WeathyTheme
import com.sbery.weathy.presentation.main.viewmodel.WeathyViewModel
import com.sbery.weathy.presentation.screens.Screen
import com.sbery.weathy.presentation.screens.location.LocationScreen
import com.sbery.weathy.presentation.screens.settings.SettingsScreen
import com.sbery.weathy.presentation.screens.splashscreen.SplashScreen
import com.sbery.weathy.presentation.screens.weather.WeatherScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeathyMainActivity : ComponentActivity() {

    private val viewModel: WeathyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initSplashScreen()
        initObservers()

        setContent {
            WeathyTheme {
                MainScreen()
            }
        }
    }

    private fun initSplashScreen() {
        installSplashScreen().setKeepOnScreenCondition {
//            viewModel.loadingState.value.not()
            false
        }
    }

    private fun initObservers() {
        viewModel.errorLiveData.observe(this) {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }

        viewModel.forecastLiveData.observe(this) {
            Toast.makeText(this, it.temp.toString() + " C", Toast.LENGTH_LONG).show()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { WeathyBottomNavigation(navController = navController) }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.SplashScreen.route
        ) {
            composable(Screen.SplashScreen.route) { SplashScreen() }
            composable(Screen.WeatherScreen.route) { WeatherScreen() }
            composable(Screen.LocationScreen.route) { LocationScreen() }
            composable(Screen.SettingsScreen.route) { SettingsScreen() }
        }
    }
}

@Preview
@Composable
fun DefaultPreview() {
    MainScreen()
}
