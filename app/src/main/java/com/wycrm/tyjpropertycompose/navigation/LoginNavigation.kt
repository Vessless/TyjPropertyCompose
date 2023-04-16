package com.wycrm.tyjpropertycompose.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wycrm.tyjpropertycompose.screens.LoginScreen

const val loginRoute = "login_route"

fun NavController.navigationToLogin(navOptions: NavOptions? = null) {
    this.navigate(loginRoute, navOptions)
}

fun NavGraphBuilder.loginScreen(function: () -> Unit) {
    composable(route = loginRoute) {
        LoginScreen(function)
    }
}