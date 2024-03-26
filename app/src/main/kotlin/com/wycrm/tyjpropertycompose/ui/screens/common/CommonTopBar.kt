package com.wycrm.tyjpropertycompose.ui.screens.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonTopBar(
    title: String,
    isNavigation: Boolean = false
) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        navigationIcon = { if (isNavigation) Icon(imageVector = Icons.Default.ArrowBackIos, contentDescription = null) else Text(text = "") }

    )
}