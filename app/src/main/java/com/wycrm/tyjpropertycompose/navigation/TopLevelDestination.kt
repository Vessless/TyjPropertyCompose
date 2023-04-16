package com.wycrm.tyjpropertycompose.navigation

import androidx.annotation.DrawableRes
import com.wycrm.tyjpropertycompose.R

enum class TopLevelDestination(
    @DrawableRes
    val selectedIcon: Int,
    @DrawableRes
    val unselectedIcon: Int,
    val iconTextId: Int,
    val titleTextId: Int
) {
    WORK_ORDER(
        selectedIcon = R.drawable.ic_launcher_background,
        unselectedIcon = R.drawable.ic_launcher_background,
        iconTextId = R.string.work_order,
        titleTextId = R.string.work_order,
    ),
    CONTACTS(
        selectedIcon = R.drawable.ic_launcher_background,
        unselectedIcon = R.drawable.ic_launcher_background,
        iconTextId = R.string.contacts,
        titleTextId = R.string.contacts,
    ),
    WORKBENCHES(
        selectedIcon = R.drawable.ic_launcher_background,
        unselectedIcon = R.drawable.ic_launcher_background,
        iconTextId = R.string.workbenches,
        titleTextId = R.string.workbenches,
    ),
    SETTINGS(
        selectedIcon = R.drawable.ic_launcher_background,
        unselectedIcon = R.drawable.ic_launcher_background,
        iconTextId = R.string.settings,
        titleTextId = R.string.settings,
    ),
}