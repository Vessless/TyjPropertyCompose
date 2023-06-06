package com.wycrm.tyjpropertycompose.ui.screens

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
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.wycrm.tyjpropertycompose.navigation.MainNavHost
import com.wycrm.tyjpropertycompose.navigation.TopLevelDestination
import com.wycrm.tyjpropertycompose.ui.MainState
import com.wycrm.tyjpropertycompose.ui.rememberMainState
import com.wycrm.tyjpropertycompose.util.NetworkMonitor


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MainScreen(
    windowSizeClass: WindowSizeClass,
    networkMonitor: NetworkMonitor,
    appState: MainState = rememberMainState(
        networkMonitor = networkMonitor,
        windowSizeClass = windowSizeClass,
    ),
    navController: NavHostController
) {

    val snackbarHostState = remember { SnackbarHostState() }

    val destinations: List<TopLevelDestination> = appState.topLevelDestinations

    val currentDestination = appState.currentDestination
    Surface() {
        Scaffold(
            containerColor = Color.Transparent,
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            snackbarHost = { SnackbarHost(hostState = snackbarHostState) },

            bottomBar = {
                BottomAppBar() {
                    destinations.forEach { destination ->
                        val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)

                        NavigationBarItem(
                            selected = selected,
                            onClick = { appState.navigateToTopLevelDestination(destination) },
                            icon = {
                                if (selected) {
                                    Icon(imageVector = destination.selectedIcon, contentDescription = null, tint = Color.Blue)
                                } else {
                                    Icon(imageVector = destination.unselectedIcon, contentDescription = null, tint = Color.Gray)
                                }

                            },
                            label = {
                                Text(stringResource(destination.iconTextId))
                            },
                        )
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
                        destinations.forEach { destination ->
                            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
                            NavigationRailItem(
                                selected = selected,
                                icon = {
                                    if (selected) {
                                        Icon(imageVector = destination.selectedIcon, contentDescription = null, tint = Color.Blue)
                                    } else {
                                        Icon(imageVector = destination.unselectedIcon, contentDescription = null, tint = Color.Gray)
                                    }
                                },
                                label = {
                                    Text(stringResource(destination.iconTextId))
                                },
                                enabled = true,
                                alwaysShowLabel = true,
                                modifier = Modifier,
                                onClick = { appState.navigateToTopLevelDestination(destination) },
                            )

                        }
                    }
                }

                Column(Modifier.fillMaxSize()) {
                    // Show the top app bar on top level destinations.
                    val destination = appState.currentTopLevelDestination
                    if (destination != null) {
                        //顶部
                        CenterAlignedTopAppBar(
                            title = { Text(stringResource(id = destination.titleTextId)) }
                        )
                    }
                    MainNavHost(navController, appState.navController)
                }
            }
        }
    }

}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false
