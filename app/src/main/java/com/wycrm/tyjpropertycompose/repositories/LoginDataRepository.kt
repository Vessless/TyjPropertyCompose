package com.wycrm.tyjpropertycompose.repositories

import com.wycrm.tyjpropertycompose.constants.DataStoreKey
import com.wycrm.tyjpropertycompose.data.BaseRequest
import com.wycrm.tyjpropertycompose.data.dao.UserDao
import com.wycrm.tyjpropertycompose.data.entities.LoginEntity
import com.wycrm.tyjpropertycompose.data.requests.LoginParams
import com.wycrm.tyjpropertycompose.network.UserApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginDataRepository @Inject constructor(
    private val userApi: UserApi,
    private val userDao: UserDao
) {
    suspend fun login(params: BaseRequest<LoginParams>) = userApi.login(params)

    suspend fun insertData(loginEntity: LoginEntity) = userDao.insertData(loginEntity)

}