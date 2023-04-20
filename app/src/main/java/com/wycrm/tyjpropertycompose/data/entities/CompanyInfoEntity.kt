package com.wycrm.tyjpropertycompose.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

/**
 * Description:
 * Date：2022/11/11 0011-10:22
 * Author: Ling
 */
@Entity(tableName = "company_info")
@Serializable
data class CompanyInfoEntity(
    @PrimaryKey(autoGenerate = false)
    val companyId: String,
    val companyCode: String,
    val companyName: String,
    val departmentCode: String,
    val departmentId: String,
    val departmentName: String,
    val loginName: String,
    val projectCode: String,
    val projectId: String,
    val projectName: String,
    val roleCode: String,
    val roleId: String,
    val roleName: String,
    val staffId: String,
    val staffName: String,
    val staffNumber: String,
    val isSelected: Boolean = false
)