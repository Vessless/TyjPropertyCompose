package com.wycrm.tyjpropertycompose.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wycrm.tyjpropertycompose.constants.Constants
import com.wycrm.tyjpropertycompose.data.BaseRequest
import com.wycrm.tyjpropertycompose.data.requests.LoginParams
import com.wycrm.tyjpropertycompose.repositories.LoginDataRepository
import com.wycrm.tyjpropertycompose.util.DecodeUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginDataRepository: LoginDataRepository
) : ViewModel() {


    fun login() {

        val time = Date().time.toString()
        val token = ""
        val data = LoginParams(
            mobile = "13300009999",
            password = DecodeUtils.RC4Base64Encry("123456"),
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

            if (code == "0" || code == "000000") {

            }

//            val userData = loginData.data

//            loginDataRepository.insertData(userData)

        }
    }

}