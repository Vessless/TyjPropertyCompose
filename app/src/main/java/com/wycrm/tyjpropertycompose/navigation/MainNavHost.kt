package com.wycrm.tyjpropertycompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun MainNavHost(
    mainController: NavHostController,
    navController: NavHostController,
    statDestination: String = workOrderRoute
) {
    NavHost(navController = navController, startDestination = statDestination) {
        workOrderScreen(mainController)
        contactsScreen()
        workbenchesScreen()
        settingsScreen()
    }

}