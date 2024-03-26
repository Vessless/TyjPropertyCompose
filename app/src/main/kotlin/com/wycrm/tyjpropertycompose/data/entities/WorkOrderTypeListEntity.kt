package com.wycrm.tyjpropertycompose.data.entities

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.wp.tyj_property.data.entity.SubcategoryEntity
import kotlinx.serialization.Serializable

@Entity(tableName = "work_order_type_list")
@Serializable
data class WorkOrderTypeListEntity(
    @PrimaryKey(autoGenerate = false)
    val levelID: Long,
    val levelName: String
) {
    @Ignore
    var subcategory: List<SubcategoryEntity> = emptyList()

}
