package com.wycrm.tyjpropertycompose.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.wycrm.tyjpropertycompose.navigation.MainNavHost
import com.wycrm.tyjpropertycompose.navigation.TopLevelDestination
import com.wycrm.tyjpropertycompose.ui.MainState
import com.wycrm.tyjpropertycompose.ui.rememberMainState
import com.wycrm.tyjpropertycompose.util.NetworkMonitor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MainScreen(
    windowSizeClass: WindowSizeClass,
    networkMonitor: NetworkMonitor,
    appState: MainState = rememberMainState(
        networkMonitor = networkMonitor,
        windowSizeClass = windowSizeClass,
    ),
) {

    val destinations: List<TopLevelDestination> = appState.topLevelDestinations

    val currentDestination = appState.currentDestination

    Surface() {
        Scaffold(
            bottomBar = {
                BottomAppBar() {
                    destinations.forEach { destination ->
                        val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)

                        NavigationBarItem(
                            selected = selected,
                            onClick = { appState::navigateToTopLevelDestination },
                            label = {
                                Text(stringResource(destination.iconTextId))
                            },

                            icon = {
                                val icon = if (selected) {
                                    destination.selectedIcon
                                } else {
                                    destination.unselectedIcon
                                }

                                Icon(painter = painterResource(id = icon), contentDescription = null)
                            })
                    }
                }
            }

        ) { padding ->
            Row(
                Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .consumeWindowInsets(padding)
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Horizontal,
                        ),
                    ),
            ) {
                if (appState.shouldShowNavRail) {
                    NavigationRail() {

                    }
                }

                Column(Modifier.fillMaxSize()) {
                    // Show the top app bar on top level destinations.
                    val destination = appState.currentTopLevelDestination
                    if (destination != null) {

                        MainNavHost(appState.navController)
                    }
                }
            }
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
