package com.app.blinkit

import android.app.Application
import com.app.blinkit.core.SvgLoader

class AppBootstrapper: Application() {
    override fun onCreate() {
        super.onCreate()

        SvgLoader.getContext(this)
    }
}