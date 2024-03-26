package com.wycrm.tyjpropertycompose.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "work_order_project_fund_source")
@Serializable
data class WorkOrderProjectFundSourceEntity(
    @PrimaryKey(autoGenerate = false)
    val fundSourceID: Int,
    val fundSourceName: String
)