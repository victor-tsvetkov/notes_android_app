package com.example.notes_app_frontend.services

import com.example.notes_app_frontend.dto.NoteRequest
import com.example.notes_app_frontend.entities.Note
import com.example.notes_app_frontend.services.api.NoteApi
import retrofit2.Response
import java.util.UUID
import javax.inject.Inject

class NoteService @Inject constructor(
    private val noteApi: NoteApi
) {
    private val tag = this.javaClass.simpleName

    suspend fun addOrUpdate(noteRequest: NoteRequest): Response<Note> {
        return noteApi.addOrUpdate(noteRequest)
    }

    suspend fun getNotesByUserId(id: UUID): Response<List<Note>> {
        return noteApi.getNotesByUserId(id)
    }
}