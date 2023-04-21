package com.wycrm.tyjpropertycompose.ui.uistate

import com.wycrm.tyjpropertycompose.data.entities.CompanyInfoEntity

sealed class MyWorkOrderUiState {
    object Default : MyWorkOrderUiState()
    object NavToSelectProject : MyWorkOrderUiState()
}