package com.wycrm.tyjpropertycompose.data.entities


import kotlinx.serialization.Serializable

@Serializable
data class WorkOrderType(
    val oneLevelId: Long?,
    val oneLevelName: String?,
    val threeLevelId: Long?,
    val threeLevelName: String?,
    val twoLevelId: Long?,
    val twoLevelName: String?
)