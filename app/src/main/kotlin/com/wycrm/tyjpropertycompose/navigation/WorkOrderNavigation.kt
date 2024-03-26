package com.wycrm.tyjpropertycompose.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wycrm.tyjpropertycompose.ui.screens.main.WorkOrderScreen

const val workOrderRoute = "work_order_route"

fun NavController.navigationToWorkOrder(navOptions: NavOptions? = null) {
    this.navigate(workOrderRoute, navOptions)
}

fun NavGraphBuilder.workOrderScreen(navHostController: NavHostController) {
    composable(route = workOrderRoute) {
        WorkOrderScreen(navHostController)
    }
}