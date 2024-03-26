package com.wycrm.tyjpropertycompose.data.requests

import kotlinx.serialization.Serializable

@Serializable
data class WorkOrder(
    val companyId: String,
    val content: String,
    val endTime: String,
    var oneLevelId: String? = null,
    var pageNo: Int?= null,
    var page: Int? = null,
    val pageSize: Int,
    val projectCode: String,
    val startTime: String,
    val workOrderStateId: String,
    var workOrderTypeId: String? = null
)