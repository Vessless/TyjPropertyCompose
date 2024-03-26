package com.wycrm.tyjpropertycompose.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "work_order_project_type")
@Serializable
data class WorkOrderProjectTypeEntity(
    @PrimaryKey(autoGenerate = false)
    val workProjectTypeId: Int,
    val workProjectTypeName: String
)