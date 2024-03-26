package com.wycrm.tyjpropertycompose.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "urgent_type")
@Serializable
data class UrgentTypeEntity(
    @PrimaryKey(autoGenerate = false)
    val rgentId: Int,
    val urgentName: String
)