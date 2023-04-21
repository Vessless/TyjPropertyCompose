package com.wycrm.tyjpropertycompose.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.wycrm.tyjpropertycompose.ui.MainState
import com.wycrm.tyjpropertycompose.ui.rememberMainState
import com.wycrm.tyjpropertycompose.util.NetworkMonitor


@Composable
fun LoginNavHost(
    modifier: Modifier = Modifier,
    startDestination: String = loginRoute,
    windowSizeClass: WindowSizeClass,
    networkMonitor: NetworkMonitor,
) {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        loginScreen(navController)
        mainScreen(windowSizeClass, networkMonitor, navController)
        selectProjectScreen()
    }
}