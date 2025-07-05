package com.app.blinkit.core.util

import AuthLocalDataSource
import android.content.Context
import androidx.room.Room
import com.app.blinkit.core.Constants
import com.app.blinkit.core.client.CacheClient

object DatabaseInitiator {
    private lateinit var appDatabase: CacheClient

    val authLocalDataSource:AuthLocalDataSource by lazy {
        AuthLocalDataSource(authDao = appDatabase.initAuthDb())
    }

    fun init(appContext: Context){
        appDatabase = Room.databaseBuilder(appContext, CacheClient::class.java, Constants.databaseName).build()
    }
}