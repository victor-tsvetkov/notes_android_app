package com.example.notes_app_frontend.services.api

import com.example.notes_app_frontend.dto.NoteRequest
import com.example.notes_app_frontend.entities.Note
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import java.util.UUID

interface NoteApi {
    @POST("note/addOrUpdate")
    suspend fun addOrUpdate(@Body noteRequest: NoteRequest): Response<Note>

    @GET("note/getNotesByUserId")
    suspend fun getNotesByUserId(@Body id: UUID): Response<List<Note>>
}