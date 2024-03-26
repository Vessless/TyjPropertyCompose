package com.wycrm.tyjpropertycompose.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.tracing.trace
import com.wycrm.tyjpropertycompose.navigation.TopLevelDestination
import com.wycrm.tyjpropertycompose.navigation.contactsRoute
import com.wycrm.tyjpropertycompose.navigation.navigationToContacts
import com.wycrm.tyjpropertycompose.navigation.navigationToSettings
import com.wycrm.tyjpropertycompose.navigation.navigationToWorkOrder
import com.wycrm.tyjpropertycompose.navigation.navigationToWorkbenches
import com.wycrm.tyjpropertycompose.navigation.settingsRoute
import com.wycrm.tyjpropertycompose.navigation.workOrderRoute
import com.wycrm.tyjpropertycompose.navigation.workbenchesRoute
import com.wycrm.tyjpropertycompose.util.NetworkMonitor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@Composable
fun rememberMainState(
    windowSizeClass: WindowSizeClass,
    networkMonitor: NetworkMonitor,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
): MainState {
    NavigationTrackingSideEffect(navController)
    return remember(navController, coroutineScope, windowSizeClass, networkMonitor) {
        MainState(navController, coroutineScope, windowSizeClass, networkMonitor)
    }
}

@Stable
class MainState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
    val windowSizeClass: WindowSizeClass,
    networkMonitor: NetworkMonitor,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            workOrderRoute -> TopLevelDestination.WORK_ORDER
            contactsRoute -> TopLevelDestination.CONTACTS
            workbenchesRoute -> TopLevelDestination.WORKBENCHES
            settingsRoute -> TopLevelDestination.SETTINGS
            else -> null
        }

    var shouldShowSettingsDialog by mutableStateOf(false)
        private set

    val shouldShowBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact

    val shouldShowNavRail: Boolean
        get() = !shouldShowBottomBar

    val isOffline = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false,
        )

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()
    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        trace("Navigation: ${topLevelDestination.name}") {
            val topLevelNavOptions = navOptions {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // reselecting the same item
                launchSingleTop = true
                // Restore state when reselecting a previously selected item
                restoreState = true
            }

            when (topLevelDestination) {
                TopLevelDestination.WORK_ORDER -> navController.navigationToWorkOrder(topLevelNavOptions)
                TopLevelDestination.CONTACTS -> navController.navigationToContacts(topLevelNavOptions)
                TopLevelDestination.WORKBENCHES -> navController.navigationToWorkbenches(topLevelNavOptions)
                TopLevelDestination.SETTINGS -> navController.navigationToSettings(topLevelNavOptions)
            }
        }
    }

    fun setShowSettingsDialog(shouldShow: Boolean) {
        shouldShowSettingsDialog = shouldShow
    }

}

@Composable
private fun NavigationTrackingSideEffect(navController: NavHostController) {
    TrackDisposableJank(navController) { metricsHolder ->
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            metricsHolder.state?.putState("Navigation", destination.route.toString())
        }

        navController.addOnDestinationChangedListener(listener)

        onDispose {
            navController.removeOnDestinationChangedListener(listener)
        }
    }
}
