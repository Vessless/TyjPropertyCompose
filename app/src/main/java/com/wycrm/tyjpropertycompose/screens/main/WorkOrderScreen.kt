package com.wycrm.tyjpropertycompose.screens.main

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
import com.wycrm.tyjpropertycompose.R
import com.wycrm.tyjpropertycompose.screens.workorder.MySuperviseScreen
import com.wycrm.tyjpropertycompose.screens.workorder.MyWorkOrderScreen
import com.wycrm.tyjpropertycompose.screens.workorder.ProjectScreen
import com.wycrm.tyjpropertycompose.screens.workorder.ServiceRequestScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun WorkOrderScreen() {

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
                0 -> MyWorkOrderScreen()
                1 -> MySuperviseScreen()
                2 -> ServiceRequestScreen()
                3 -> ProjectScreen()
                else -> {}
            }
        }
    }
}