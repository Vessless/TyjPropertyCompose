package com.wycrm.tyjpropertycompose.data

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val data: T? = null,
    val code: String,
    val message: String
)