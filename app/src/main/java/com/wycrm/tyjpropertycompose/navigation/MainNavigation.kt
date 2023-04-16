package com.wycrm.tyjpropertycompose.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wycrm.tyjpropertycompose.screens.MainScreen
import com.wycrm.tyjpropertycompose.ui.MainState
import com.wycrm.tyjpropertycompose.util.NetworkMonitor

const val mainRoute = "main_route"

fun NavController.navigationToMain(navOptions: NavOptions? = null) {
    this.navigate(loginRoute, navOptions)
}

fun NavGraphBuilder.mainScreen(windowSizeClass: WindowSizeClass,
                               networkMonitor: NetworkMonitor,
                               appState: MainState ) {
    composable(route = mainRoute) {
        MainScreen(windowSizeClass,networkMonitor,appState)
    }
}