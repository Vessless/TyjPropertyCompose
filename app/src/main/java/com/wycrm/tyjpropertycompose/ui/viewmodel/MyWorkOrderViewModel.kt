package com.wycrm.tyjpropertycompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wycrm.tyjpropertycompose.constants.DataStoreKey
import com.wycrm.tyjpropertycompose.data.BaseRequest
import com.wycrm.tyjpropertycompose.data.requests.AccountId
import com.wycrm.tyjpropertycompose.repositories.DataStoreRepository
import com.wycrm.tyjpropertycompose.repositories.MyWorkOrderRepository
import com.wycrm.tyjpropertycompose.util.DecodeUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class MyWorkOrderViewModel @Inject constructor(
    private val myWorkOrderRepository: MyWorkOrderRepository,
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {


    fun getCompanyInfo() {
        viewModelScope.launch {
            val phone = dataStoreRepository.getString(DataStoreKey.LOGIN_PHONE)
            val time = Date().time.toString()
            val loginEntity = myWorkOrderRepository.getUser(phone)[0]
            val token = dataStoreRepository.getString(DataStoreKey.HTTP_TOKEN)
            val data = AccountId(loginEntity.accountId)
            val dataString = Json.encodeToString(data)
            val request = BaseRequest(
                data = data,
                timestamp = time,
                sign = DecodeUtils.getSign(token, dataString, time),
                token = token
            )


            myWorkOrderRepository.getCompanyInfo(request)
        }
    }

    fun getWorkOrderConfig() {
        viewModelScope.launch {
            val time = Date().time.toString()
            val token = dataStoreRepository.getString(DataStoreKey.HTTP_TOKEN)
            val data = AccountId("")
            val dataString = Json.encodeToString(data)
            val request = BaseRequest(
                data = data,
                timestamp = time,
                sign = DecodeUtils.getSign(token, dataString, time),
                token = token
            )


//            myWorkOrderRepository.getCompanyInfo(request)
        }
    }
}