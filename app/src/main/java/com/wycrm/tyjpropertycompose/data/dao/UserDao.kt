package com.wycrm.tyjpropertycompose.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wycrm.tyjpropertycompose.data.entities.LoginEntity

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    suspend fun loadAll(): List<LoginEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertData(loginEntity: LoginEntity)

    @Delete
    suspend fun deleteData(loginEntity: LoginEntity)

    @Query("SELECT * FROM user WHERE accountName = (:phone)")
    suspend fun getUserByPhone(phone: String): List<LoginEntity>

    @Query("DELETE FROM user")
    suspend fun deleteAll()
}