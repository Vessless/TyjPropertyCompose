package com.wycrm.tyjpropertycompose.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wycrm.tyjpropertycompose.screens.MainScreen
import com.wycrm.tyjpropertycompose.screens.main.SettingsScreen

const val settingsRoute = "settings_route"

fun NavController.navigationToSettings(navOptions: NavOptions? = null) {
    this.navigate(loginRoute, navOptions)
}

fun NavGraphBuilder.settingsScreen() {
    composable(route = settingsRoute) {
        SettingsScreen()
    }
}