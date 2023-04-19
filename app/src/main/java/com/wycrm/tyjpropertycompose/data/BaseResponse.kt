package com.wycrm.tyjpropertycompose.data

import com.wycrm.tyjpropertycompose.network.BaseSerializer
import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val data: T?,
    val code: String,
    val message: String
)