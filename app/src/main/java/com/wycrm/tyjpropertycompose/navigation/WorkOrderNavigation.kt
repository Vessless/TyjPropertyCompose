package com.wycrm.tyjpropertycompose.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wycrm.tyjpropertycompose.screens.main.WorkOrderScreen

const val workOrderRoute = "work_order_route"

fun NavController.navigationToWorkOrder(navOptions: NavOptions? = null) {
    this.navigate(workOrderRoute, navOptions)
}

fun NavGraphBuilder.workOrderScreen() {
    composable(route = workOrderRoute) {
        WorkOrderScreen()
    }
}