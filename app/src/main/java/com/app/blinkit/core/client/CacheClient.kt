package com.app.blinkit.core.client

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.blinkit.data.datasource.local.auth.AuthDao
import com.app.blinkit.data.entity.response.cache.AuthCacheDto

@Database(
    entities = [AuthCacheDto::class],
    version = 1,
    exportSchema = false,
)
abstract class CacheClient: RoomDatabase() {
    abstract fun initAuthDb(): AuthDao
}