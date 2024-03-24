package com.example.notes_app_frontend.dagger_components

import com.example.notes_app_frontend.AuthenticationActivity
import com.example.notes_app_frontend.MainActivity
import com.example.notes_app_frontend.modules.ApiModule
import dagger.Component

@Component(modules = [ApiModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: AuthenticationActivity)
}