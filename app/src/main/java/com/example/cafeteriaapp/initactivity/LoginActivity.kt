package com.example.cafeteriaapp.initactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.cafeteriaapp.MainActivity
import com.example.cafeteriaapp.R
import com.example.cafeteriaapp.databinding.ActivityLoginBinding
import com.example.cafeteriaapp.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel = LoginViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val userEditText = binding.editTextText.text.toString()
            val passEditText = binding.editTextTextPassword.text.toString()

            loginViewModel.login(userEditText, passEditText)
            if(loginViewModel.isLoggedIn.value == true) {
                Toast.makeText(this, "Login Correcte", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                Toast.makeText(this, "Credencials Incorrectes", Toast.LENGTH_SHORT).show()
            }
        }
    }
}