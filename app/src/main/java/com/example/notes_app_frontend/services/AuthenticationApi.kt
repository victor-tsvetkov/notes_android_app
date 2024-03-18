package com.example.notes_app_frontend.services

import com.example.notes_app_frontend.dto.RegisterRequest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticationApi {

    @POST("auth/register")
    fun register(@Body registerRequest: RegisterRequest): Call<ResponseBody>
}