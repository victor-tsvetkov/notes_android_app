package com.example.notes_app_frontend.dto

import com.example.notes_app_frontend.entities.User

data class AuthenticationResponse(
    val token: String,
    val user: User
)