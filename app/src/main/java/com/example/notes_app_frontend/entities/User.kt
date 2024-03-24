package com.example.notes_app_frontend.entities

import com.google.gson.annotations.SerializedName
import java.util.UUID

data class User(
    @SerializedName("id")
    val id: UUID,

    @SerializedName("name")
    val name: String,

    @SerializedName("lastname")
    val lastname: String,

    @SerializedName("creation_date")
    val creationDate: String,

    @SerializedName("update_date")
    val updateDate: String,

    @SerializedName("username")
    val username: String,

    @SerializedName("password")
    val password: String
)