package com.wycrm.tyjpropertycompose.ui.uistate

sealed class LoginUiState {
    object Default : LoginUiState()
    object Loading : LoginUiState()
    object Success : LoginUiState()
    data class Failure(val errorMessage: String) : LoginUiState()
}