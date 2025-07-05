package com.app.blinkit

import android.app.Application
import com.app.blinkit.core.SvgLoader
import com.app.blinkit.core.client.ApiClient
import com.app.blinkit.core.util.DatabaseInitiator

class AppBootstrapper: Application() {
    override fun onCreate() {
        super.onCreate()

        SvgLoader.getContext(this)
        ApiClient.initRetrofit()
        DatabaseInitiator.init(this)
    }
}