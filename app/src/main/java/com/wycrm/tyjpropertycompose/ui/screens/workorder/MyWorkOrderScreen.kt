package com.wycrm.tyjpropertycompose.ui.screens.workorder

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyWorkOrderScreen() {
    val itemsList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    val state = rememberLazyListState()

    val refreshing = false
    val refreshState = rememberPullRefreshState(refreshing = refreshing, onRefresh = { /*TODO*/ })
    Box(Modifier.pullRefresh(refreshState)) {
        LazyColumn(state = state) {
            items(itemsList) {
                Text(
                    text = "Column Item :$it",
                    modifier = Modifier.height(100.dp)
                )
            }
        }
        PullRefreshIndicator(refreshing = refreshing, state = refreshState)
    }


}