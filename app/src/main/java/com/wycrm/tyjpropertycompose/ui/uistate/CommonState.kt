package com.wycrm.tyjpropertycompose.ui.uistate

data class CommonState(val code: String) {
    val isSuccess: Boolean
        get() = (code == "000000" || code == "0" || code == "2000000")
}
