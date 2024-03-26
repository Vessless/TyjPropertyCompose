package com.wycrm.tyjpropertycompose.ui.screens.workorder

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.wycrm.tyjpropertycompose.navigation.navigationToSelectProject

@Composable
fun MySuperviseScreen(
    navController: NavHostController
) {

    Column() {
        Text(text = "我的督办")

        Button(onClick = {
            navController.navigationToSelectProject()
        }) {
            Text(text = "点击跳转")
        }
    }
}