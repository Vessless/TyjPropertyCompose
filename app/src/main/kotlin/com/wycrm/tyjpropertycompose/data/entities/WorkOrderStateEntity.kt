package com.wycrm.tyjpropertycompose.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "work_order_state")
@Serializable
data class WorkOrderStateEntity(
    @PrimaryKey(autoGenerate = false)
    val stateId: Int,
    val stateName: String
)