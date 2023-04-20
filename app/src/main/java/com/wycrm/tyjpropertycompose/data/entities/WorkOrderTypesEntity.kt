package com.wycrm.tyjpropertycompose.data.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.wp.tyj_property.data.entity.SubcategoryEntity
import kotlinx.serialization.Serializable

@Entity(tableName = "work_order_type")
@Serializable
data class WorkOrderTypesEntity(
    @PrimaryKey(autoGenerate = false)
    val levelID: Long,
    val levelName: String
) {
    @Ignore
    val subcategory: List<SubcategoryEntity> = emptyList()
}
