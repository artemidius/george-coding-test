package com.sborets.codingtest.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CodingTestApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}