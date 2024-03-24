package com.example.notes_app_frontend.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.notes_app_frontend.R
import com.example.notes_app_frontend.entities.User
import com.google.gson.Gson

class UserActivity : AppCompatActivity() {

    private var user: User? = null
    private lateinit var username: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val userData = intent.getStringExtra("userData")
        user = Gson().fromJson(userData, User::class.java)

        username = findViewById(R.id.username)
        username.text = "Имя пользователя: ${user?.name} ${user?.lastname}"
    }
}