package com.example.notes_app_frontend

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.notes_app_frontend.dto.RegisterRequest
import com.example.notes_app_frontend.services.AuthenticationService
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var authenticationService: AuthenticationService

    private lateinit var nameInput: EditText
    private lateinit var lastnameInput: EditText
    private lateinit var usernameInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var buttonSignup: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameInput = findViewById(R.id.inputName)
        lastnameInput = findViewById(R.id.inputLastname)
        usernameInput = findViewById(R.id.inputUsername)
        passwordInput = findViewById(R.id.inputPassword)
        buttonSignup = findViewById(R.id.buttonSignup)

        (applicationContext as MainApp).appComponent.inject(this)

        buttonSignup.setOnClickListener {
            if (nameInput.text.isNotEmpty() && lastnameInput.text.isNotEmpty()
                && usernameInput.text.isNotEmpty() && passwordInput.text.isNotEmpty()) {
                val registerRequest = RegisterRequest(nameInput.text.toString(),
                    lastnameInput.text.toString(), usernameInput.text.toString(),
                    passwordInput.text.toString())
                authenticationService.register(registerRequest)
                clearInputs()
            }
        }
    }

    private fun clearInputs() {
        nameInput.setText("")
        lastnameInput.setText("")
        usernameInput.setText("")
        passwordInput.setText("")
    }
}