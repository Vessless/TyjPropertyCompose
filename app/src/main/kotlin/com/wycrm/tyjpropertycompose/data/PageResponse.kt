package com.wycrm.tyjpropertycompose.data

import kotlinx.serialization.Serializable

@Serializable
data class PageResponse<T : Any>(
    val current: Int,
    val records: List<T>,
    val size: Int,
    val total: Int
)
