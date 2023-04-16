package com.wycrm.tyjpropertycompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun MainNavHost(
    navController: NavHostController,
    statDestination: String = workOrderRoute
) {
    NavHost(navController = navController, startDestination = statDestination) {
        workOrderScreen()
        contactsScreen()
        workbenchesScreen()
        settingsScreen()
    }

}