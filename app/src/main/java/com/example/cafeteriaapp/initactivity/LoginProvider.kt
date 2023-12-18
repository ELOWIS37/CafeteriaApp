package com.example.cafeteriaapp.initactivity

class LoginProvider {
    companion object {
        private val logins = listOf(
            LoginModel(
                user = "Eloy",
                password = "Eloy123"
            ),
            LoginModel(
                user = "Marc",
                password = "Marc123"
            ),
            LoginModel(
                user = "Jordi",
                password = "Jordi111"
            )
        )
    }
}