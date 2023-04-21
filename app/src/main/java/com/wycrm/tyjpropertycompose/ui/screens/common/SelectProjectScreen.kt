package com.wycrm.tyjpropertycompose.ui.screens.common

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Domain
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.wycrm.tyjpropertycompose.R
import com.wycrm.tyjpropertycompose.data.entities.CompanyInfoEntity
import com.wycrm.tyjpropertycompose.ui.uistate.MyWorkOrderUiState
import com.wycrm.tyjpropertycompose.ui.viewmodel.MyWorkOrderViewModel
import kotlinx.coroutines.launch

private const val TAG = "SelectProjectScreen"

@Composable
fun SelectProjectScreen(

) {
    val myWorkOrderViewModel: MyWorkOrderViewModel = hiltViewModel()
    val listFlow = myWorkOrderViewModel.projectList

    val list: MutableList<CompanyInfoEntity> = mutableListOf()
    LaunchedEffect(key1 = listFlow) {
        launch {
            listFlow.collect {
                Log.i(TAG, "SelectProjectScreen: ====== size = ${it.size}")
                list.addAll(it)
            }
        }
    }

    Log.i(TAG, "SelectProjectScreen: size = ${list.size}")
    val state = rememberLazyListState()

    Column(
        modifier = Modifier.fillMaxSize()

    ) {

        CommonTopBar(
            title = stringResource(id = R.string.select_current_project),
            isNavigation = true
        )

        LazyColumn(state = state) {
            items(list) {
                Card() {
                    Row() {
                        Checkbox(checked = it.isSelected, onCheckedChange = {})
                        Icon(imageVector = Icons.Default.Domain, contentDescription = null)
                        Column() {
                            Text(text = it.companyName)
                            Text(text = it.projectName)
                        }
                    }
                }
            }
        }

    }

}