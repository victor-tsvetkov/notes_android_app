package com.example.notes_app_frontend.dto

import java.util.UUID

data class NoteRequest(
    val id: UUID?,
    val noteText: String?,
    val idUser: UUID
)