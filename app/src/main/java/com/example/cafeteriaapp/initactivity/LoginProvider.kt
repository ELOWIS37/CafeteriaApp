package com.example.cafeteriaapp.initactivity

class LoginProvider {
    companion object {

        fun validateCredentials(login: String, password: String): Boolean {
            return users.any { it.user == login && it.password == password }
        }

        private val users = listOf(
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