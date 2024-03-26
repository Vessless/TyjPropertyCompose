package com.wycrm.tyjpropertycompose.data.entities

import kotlinx.serialization.Serializable

@Serializable
data class MyWorkOrderEntity(
    val contactMobile: String?,
    val contactName: String?,
    val content: String?,
    val createTime: String?,
    val custId: String?,
    val estimatedFinishTime: String?,
    val handlerMobile: String?,
    val handlerName: String?,
    val id: Long?,
    val isMerge: Int?,
    val oneOrderId: Long?,
    val records: List<RecordX>?,
    val reminders: Int?,
    val returnVisit: Int?,
    val status: Int?,
    val threeOrderId: Long?,
    val twoOrderId: Long?,
    val urgentId: Int?,
    val urgentName: String?,
    val workOrderAddress: String?,
    val workOrderAddressId: String?,
    val workOrderId: String?,
    val workOrderProjectId: Long?,
    val workOrderType: WorkOrderType?
)