package com.wycrm.tyjpropertycompose.data.requests

import kotlinx.serialization.Serializable

@Serializable
data class CompanyAndProjectCode(
    val companyId: String,
    val projectCode: String
)
