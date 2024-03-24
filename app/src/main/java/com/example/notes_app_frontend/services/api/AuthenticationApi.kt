package com.example.notes_app_frontend.services.api

import com.example.notes_app_frontend.dto.AuthenticationRequest
import com.example.notes_app_frontend.dto.AuthenticationResponse
import com.example.notes_app_frontend.dto.RegisterRequest
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.Response

interface AuthenticationApi {

    @POST("auth/register")
    fun register(@Body registerRequest: RegisterRequest): Call<ResponseBody>

    @POST("auth/authenticate")
    suspend fun authenticate(@Body authenticationRequest: AuthenticationRequest): Response<AuthenticationResponse>
}