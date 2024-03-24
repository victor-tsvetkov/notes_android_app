package com.example.notes_app_frontend.modules

import com.example.notes_app_frontend.services.api.AuthenticationApi
import com.example.notes_app_frontend.services.api.NoteApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        val baseUrl = "http://10.0.2.2:8080"
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthenticationApi {
        return retrofit.create(AuthenticationApi::class.java)
    }

    @Provides
    fun provideNoteApi(retrofit: Retrofit): NoteApi {
        return retrofit.create(NoteApi::class.java)
    }

}