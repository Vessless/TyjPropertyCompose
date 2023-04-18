package com.wycrm.tyjpropertycompose.data.requests

import kotlinx.serialization.Serializable

@Serializable
data class LoginParams(
    val mobile: String,
    val password: String,
    val sourceType: String,
    val verificationCode: String? = null
)
