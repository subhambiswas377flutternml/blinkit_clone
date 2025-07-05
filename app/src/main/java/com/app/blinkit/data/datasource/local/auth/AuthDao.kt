package com.app.blinkit.data.datasource.local.auth

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.app.blinkit.data.entity.response.cache.AuthCacheDto
import kotlinx.coroutines.flow.Flow

@Dao
abstract class AuthDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insert(authData: AuthCacheDto)

    @Query("Select * from `auth_table`")
    abstract fun get():Flow<List<AuthCacheDto>>

    @Update
    abstract suspend fun update(authData: AuthCacheDto)

    @Delete
    abstract suspend fun delete(authData: AuthCacheDto)
}