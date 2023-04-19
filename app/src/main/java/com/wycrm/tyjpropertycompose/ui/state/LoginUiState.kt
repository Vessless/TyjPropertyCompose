package com.wycrm.tyjpropertycompose.ui.state

sealed interface LoginUiState {
    object Loading : LoginUiState
    object Success : LoginUiState
    object Failure : LoginUiState
}