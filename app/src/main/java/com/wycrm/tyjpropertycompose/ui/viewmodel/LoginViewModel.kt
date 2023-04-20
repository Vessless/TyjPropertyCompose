package com.wycrm.tyjpropertycompose.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wycrm.tyjpropertycompose.constants.Constants
import com.wycrm.tyjpropertycompose.constants.DataStoreKey
import com.wycrm.tyjpropertycompose.data.BaseRequest
import com.wycrm.tyjpropertycompose.data.entities.LoginEntity
import com.wycrm.tyjpropertycompose.data.requests.LoginParams
import com.wycrm.tyjpropertycompose.repositories.DataStoreRepository
import com.wycrm.tyjpropertycompose.repositories.LoginDataRepository
import com.wycrm.tyjpropertycompose.ui.uistate.CommonState
import com.wycrm.tyjpropertycompose.ui.uistate.LoginUiState
import com.wycrm.tyjpropertycompose.util.DecodeUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginDataRepository: LoginDataRepository,
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    companion object {
        private const val TAG = "LoginViewModel"
    }

    private val _uiState = MutableStateFlow<LoginUiState>(LoginUiState.Default)

    val uiState = _uiState.asStateFlow()


    var account by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    fun updateAccount(account: String) {
        this.account = account
    }

    fun updatePassword(password: String) {
        this.password = password
    }

    fun login() {
        val time = Date().time.toString()
        val token = ""
        val data = LoginParams(
            mobile = account,
            password = DecodeUtils.RC4Base64Encry(password),
            sourceType = Constants.SOURCE_TYPE
        )
        val dataString = Json.encodeToString(data)

        val requestParams = BaseRequest(
            data = data,
            sign = DecodeUtils.getSign(token, dataString, time),
            token = token,
            timestamp = time
        )

        viewModelScope.launch {
            val loginData = loginDataRepository.login(requestParams)

            val code = loginData.code
            if (CommonState(code).isSuccess) {
                Log.i(TAG, "login: code = $code, message  = ${loginData.message} ")
                dataStoreRepository.putString(DataStoreKey.LOGIN_PHONE, account)
                dataStoreRepository.putString(DataStoreKey.LOGIN_PASSWORD, password)
                loginData.data?.let {
                    loginDataRepository.insertData(it)
                    dataStoreRepository.putString(DataStoreKey.HTTP_TOKEN, it.token)
                }

                _uiState.value = LoginUiState.Success
            } else {
                Log.i(TAG, "login: code = $code, message  = ${loginData.message} ")
                _uiState.value = LoginUiState.Failure(loginData.message)
            }

        }
    }

}


