package com.example.notes_app_frontend.services

import android.util.Log
import com.example.notes_app_frontend.dto.AuthenticationRequest
import com.example.notes_app_frontend.dto.AuthenticationResponse
import com.example.notes_app_frontend.dto.RegisterRequest
import com.example.notes_app_frontend.services.api.AuthenticationApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class AuthenticationService @Inject constructor(
    private val api: AuthenticationApi
) {

    private val tag = this.javaClass.simpleName

    fun register(registerRequest: RegisterRequest) {
        val postRequest = api.register(registerRequest)
        postRequest.enqueue(object: Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    Log.d(tag, "User successfully registered")
                } else {
                    Log.e(tag, "Error occurred: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e(tag, "An error occurred on failure method: $t")
            }
        })
    }

    suspend fun authenticate(authenticationRequest: AuthenticationRequest): Response<AuthenticationResponse> {
        return api.authenticate(authenticationRequest)
    }

}
