package com.example.daggerhiltdependencydemoapplication.baseapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class BaseApplication:Application(){



    companion object {
        private var instance: BaseApplication? = null
        fun applicationContext(): BaseApplication {
            return instance as BaseApplication
        }
    }

    init {
        instance = this
    }
}