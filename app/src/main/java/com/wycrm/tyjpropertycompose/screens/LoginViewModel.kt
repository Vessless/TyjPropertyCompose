package com.wycrm.tyjpropertycompose.screens

import androidx.lifecycle.ViewModel
import com.wycrm.tyjpropertycompose.repositories.LoginDataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    loginDataRepository: LoginDataRepository
) : ViewModel() {


}