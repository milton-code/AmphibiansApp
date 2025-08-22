package com.proyecto.amphibiansapp;

import android.app.Application
import com.proyecto.amphibiansapp.data.AppContainer
import com.proyecto.amphibiansapp.data.DefaultAppContainer

class AmphibiansApplication: Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}
