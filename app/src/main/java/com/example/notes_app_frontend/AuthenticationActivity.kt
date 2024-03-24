package com.example.notes_app_frontend

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.notes_app_frontend.activities.UserActivity
import com.example.notes_app_frontend.dto.AuthenticationRequest
import com.example.notes_app_frontend.entities.User
import com.example.notes_app_frontend.services.AuthenticationService
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthenticationActivity : AppCompatActivity() {

    private var userEntity: User? = null
    private var token: String? = null
    @Inject
    lateinit var authenticationService: AuthenticationService

    private lateinit var inputNameSignIn: EditText
    private lateinit var inputLastnameSignIn: EditText
    private lateinit var buttonSignIn: Button
    private val tag = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)

        (applicationContext as MainApp).appComponent.inject(this)

        inputNameSignIn = findViewById(R.id.inputNameSignIn)
        inputLastnameSignIn = findViewById(R.id.inputLastnameSignIn)
        buttonSignIn = findViewById(R.id.buttonSignIn)
        buttonSignIn.setOnClickListener {
            signIn()
        }
    }

    private fun signIn() {
        if (inputNameSignIn.text.isNotEmpty() && inputLastnameSignIn.text.isNotEmpty()) {
            val authenticationRequest = AuthenticationRequest(
                inputNameSignIn.text.toString(), inputLastnameSignIn.text.toString())

            CoroutineScope(Dispatchers.IO).launch {
                val response = authenticationService.authenticate(authenticationRequest)
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        val result = response.body()
                        token = result?.token
                        userEntity = result?.user
                        val intent = Intent(baseContext, UserActivity::class.java)
                        val userData = Gson().toJson(userEntity)
                        intent.putExtra("userData", userData)
                        startActivity(intent)
                        Log.d(tag, "User successfully authenticated")
                    } else {
                        Log.e(tag, "Authentication failed")
                    }
                }
            }
        }
    }
}