package com.wycrm.tyjpropertycompose.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.wycrm.tyjpropertycompose.R

enum class TopLevelDestination(
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val iconTextId: Int,
    val titleTextId: Int
) {
    WORK_ORDER(
        selectedIcon = Icons.Default.ListAlt,
        unselectedIcon = Icons.Default.ListAlt,
        iconTextId = R.string.work_order,
        titleTextId = R.string.work_order,
    ),
    CONTACTS(
        selectedIcon = Icons.Default.Contacts,
        unselectedIcon = Icons.Default.Contacts,
        iconTextId = R.string.contacts,
        titleTextId = R.string.contacts,
    ),
    WORKBENCHES(
        selectedIcon = Icons.Default.GridView,
        unselectedIcon = Icons.Default.GridView,
        iconTextId = R.string.workbenches,
        titleTextId = R.string.workbenches,
    ),
    SETTINGS(
        selectedIcon = Icons.Default.Settings,
        unselectedIcon = Icons.Default.Settings,
        iconTextId = R.string.settings,
        titleTextId = R.string.settings,
    ),
}