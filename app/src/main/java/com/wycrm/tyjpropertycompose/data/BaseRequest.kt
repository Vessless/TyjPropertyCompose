package com.wycrm.tyjpropertycompose.data

import kotlinx.serialization.Serializable

@Serializable
data class BaseRequest<T>(
    val data: T? = null,
    val sign: String,
    val timestamp: String,
    val token: String
)
