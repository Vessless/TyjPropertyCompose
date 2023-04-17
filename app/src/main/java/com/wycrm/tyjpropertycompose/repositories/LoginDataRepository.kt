package com.wycrm.tyjpropertycompose.repositories

import com.wycrm.tyjpropertycompose.network.UserApi
import javax.inject.Inject

class LoginDataRepository @Inject constructor(
    private val userApi: UserApi
) {
    suspend fun login(params: String) = userApi.login(params)
}