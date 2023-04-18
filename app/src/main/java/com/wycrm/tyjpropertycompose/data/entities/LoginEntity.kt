package com.wycrm.tyjpropertycompose.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "user")
@Serializable
data class LoginEntity(
    @PrimaryKey(autoGenerate = false)
    val accountId: String,
    val accountCode: String,
    val accountName: String,
    val nickName: String,
    val registerCompany: String,
    val signatures: String,
    val token: String,
    val sex: String,
    val icon: String
)