package com.example.notes_app_frontend.dto

data class RegisterRequest(
    val name: String,
    val lastname: String,
    val username: String,
    val password: String
)