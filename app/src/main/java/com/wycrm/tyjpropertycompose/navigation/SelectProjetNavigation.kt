package com.wycrm.tyjpropertycompose.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.wycrm.tyjpropertycompose.ui.screens.common.SelectProjectScreen


const val selectProjectRoute = "select_project_route"
fun NavHostController.navigationToSelectProject(){
    this.navigate(selectProjectRoute)
}

fun NavGraphBuilder.selectProjectScreen(){
    composable(route = selectProjectRoute){
        SelectProjectScreen()
    }
}