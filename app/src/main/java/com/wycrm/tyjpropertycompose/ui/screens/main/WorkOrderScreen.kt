package com.wycrm.tyjpropertycompose.ui.screens.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringArrayResource
import androidx.navigation.NavHostController
import com.wycrm.tyjpropertycompose.R
import com.wycrm.tyjpropertycompose.ui.screens.workorder.MySuperviseScreen
import com.wycrm.tyjpropertycompose.ui.screens.workorder.MyWorkOrderScreen
import com.wycrm.tyjpropertycompose.ui.screens.workorder.ProjectScreen
import com.wycrm.tyjpropertycompose.ui.screens.workorder.ServiceRequestScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WorkOrderScreen(
    navController: NavHostController,
) {

    val pagerState = rememberPagerState()

    val coroutineScope = rememberCoroutineScope()

    Column {
        TabRow(selectedTabIndex = pagerState.currentPage) {
            val stringList = stringArrayResource(id = R.array.order_tab_title)

            stringList.forEachIndexed { index, s ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.scrollToPage(index)
                        }
                    },
                    text = { Text(text = s) },
                )
            }

        }
        HorizontalPager(
            state = pagerState,
            pageCount = 4
        ) {
            when (it) {
                0 -> MyWorkOrderScreen(navController)
                1 -> MySuperviseScreen(navController)
                2 -> ServiceRequestScreen(navController)
                3 -> ProjectScreen(navController)
                else -> {}
            }
        }

    }
}