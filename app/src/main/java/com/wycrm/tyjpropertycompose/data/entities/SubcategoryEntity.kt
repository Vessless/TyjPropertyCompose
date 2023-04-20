package com.wp.tyj_property.data.entity

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "subcategory")
@Serializable
data class SubcategoryEntity(
    @PrimaryKey(autoGenerate = false)
    val levelID: Long,
    val levelName: String,
    val parentId: Long,
    val subcategory: List<SubcategoryXEntity>
)