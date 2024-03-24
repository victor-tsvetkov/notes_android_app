package com.example.notes_app_frontend.entities

import java.time.LocalDateTime
import java.util.UUID

data class Note(
    val id: UUID,
    val creationDate: LocalDateTime,
    val updateDate: LocalDateTime?,
    val noteText: String?,
    val user: User
)
