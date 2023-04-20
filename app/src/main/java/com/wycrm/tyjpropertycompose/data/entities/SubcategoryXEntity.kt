package com.wp.tyj_property.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "subcategory_x")
@Serializable
data class SubcategoryXEntity(
    @PrimaryKey(autoGenerate = false)
    val levelID: Long,
    val levelName: String,
    val parentId: Long
)