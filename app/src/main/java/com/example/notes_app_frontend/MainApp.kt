package com.example.notes_app_frontend

import android.app.Application
import com.example.notes_app_frontend.dagger_components.AppComponent
import com.example.notes_app_frontend.dagger_components.DaggerAppComponent

class MainApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }

}