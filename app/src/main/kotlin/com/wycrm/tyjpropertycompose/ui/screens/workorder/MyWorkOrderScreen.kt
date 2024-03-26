package com.wycrm.tyjpropertycompose.ui.screens.workorder

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.wycrm.tyjpropertycompose.navigation.navigationToSelectProject
import com.wycrm.tyjpropertycompose.ui.uistate.MyWorkOrderUiState
import com.wycrm.tyjpropertycompose.ui.viewmodel.MyWorkOrderViewModel
import kotlinx.coroutines.launch

private const val TAG = "MyWorkOrderScreen"

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@Composable
fun MyWorkOrderScreen(
    navController: NavHostController,
    viewModel: MyWorkOrderViewModel = hiltViewModel()
) {

    Log.i(TAG, "MyWorkOrderScreen:  why do twice ")


    val uiState = viewModel.uiState
    LaunchedEffect(key1 = uiState) {
        launch {
            uiState.collect {
                when (it) {
                    MyWorkOrderUiState.Default -> viewModel.getCompanyInfo()
                    MyWorkOrderUiState.NavToSelectProject -> Unit
                }
            }
        }
    }

    val itemsList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
    val state = rememberLazyListState()

    val refreshing = false
    val refreshState = rememberPullRefreshState(refreshing = refreshing, onRefresh = { /*TODO*/ })

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {


        Box(Modifier.pullRefresh(refreshState)) {
            LazyColumn(
                state = state,
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(itemsList) {
                    Card(
                        onClick = {
                            Log.i(TAG, "MyWorkOrderScreen: click item")
                            navController.navigationToSelectProject()
                        },
                        shape = RoundedCornerShape(16.dp),
                        modifier = Modifier
                            .height(100.dp)
                            .fillMaxWidth(),
                    ) {
                        Text(text = "Column Item :$it")
                    }

                }
            }
            PullRefreshIndicator(refreshing = refreshing, state = refreshState)
        }

        Button(onClick = { navController.navigationToSelectProject() }) {
            Text(text = "点击跳转")
        }

//        MyWorkOrderNavHost()
    }


}