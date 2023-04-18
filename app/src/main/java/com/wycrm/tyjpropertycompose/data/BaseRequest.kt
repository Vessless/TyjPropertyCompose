package com.wycrm.tyjpropertycompose.data

import kotlinx.serialization.Serializable

@Serializable
data class BaseRequest<T : Any>(
    val data: T,
    val sign: String,
    val timestamp: String,
    val token: String
)
