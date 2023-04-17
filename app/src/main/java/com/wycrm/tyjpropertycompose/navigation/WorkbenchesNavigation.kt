package com.wycrm.tyjpropertycompose.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wycrm.tyjpropertycompose.screens.main.WorkbenchesScreen

const val workbenchesRoute = "workbenches_route"

fun NavController.navigationToWorkbenches(navOptions: NavOptions? = null) {
    this.navigate(workbenchesRoute, navOptions)
}

fun NavGraphBuilder.workbenchesScreen() {
    composable(route = workbenchesRoute) {
        WorkbenchesScreen()
    }
}