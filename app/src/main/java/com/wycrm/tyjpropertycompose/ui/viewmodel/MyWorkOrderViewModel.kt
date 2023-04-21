package com.wycrm.tyjpropertycompose.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wycrm.tyjpropertycompose.constants.DataStoreKey
import com.wycrm.tyjpropertycompose.data.BaseRequest
import com.wycrm.tyjpropertycompose.data.entities.CompanyInfoEntity
import com.wycrm.tyjpropertycompose.data.requests.AccountId
import com.wycrm.tyjpropertycompose.repositories.DataStoreRepository
import com.wycrm.tyjpropertycompose.repositories.MyWorkOrderRepository
import com.wycrm.tyjpropertycompose.ui.uistate.CommonState
import com.wycrm.tyjpropertycompose.ui.uistate.MyWorkOrderUiState
import com.wycrm.tyjpropertycompose.util.DecodeUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.Date
import javax.inject.Inject

private const val TAG = "MyWorkOrderViewModel"

@HiltViewModel
class MyWorkOrderViewModel @Inject constructor(
    private val myWorkOrderRepository: MyWorkOrderRepository,
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<MyWorkOrderUiState>(MyWorkOrderUiState.Default)
    val uiState = _uiState.asStateFlow()

    private val _projectList = MutableStateFlow<MutableList<CompanyInfoEntity>>(mutableListOf())

    val projectList = _projectList.asStateFlow()

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


            val companyData = myWorkOrderRepository.getCompanyInfo(request)

            if (CommonState(companyData.code).isSuccess) {
                companyData.data?.let {
                    Log.i(TAG, "getCompanyInfo:  size = ${it.size}")
                    if (it.size > 1) {
                        _projectList.value = companyData.data as MutableList<CompanyInfoEntity>
                        _uiState.value = MyWorkOrderUiState.NavToSelectProject
                    }
                }
            }
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