package com.wycrm.tyjpropertycompose.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.wycrm.tyjpropertycompose.screens.main.ContactsScreen

const val contactsRoute = "contacts_route"

fun NavController.navigationToContacts(navOptions: NavOptions? = null) {
    this.navigate(loginRoute, navOptions)
}

fun NavGraphBuilder.contactsScreen() {
    composable(route = contactsRoute) {
        ContactsScreen()
    }
}