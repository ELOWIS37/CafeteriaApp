package com.example.cafeteriaapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cafeteriaapp.initactivity.LoginActivity
import com.example.cafeteriaapp.initactivity.LoginProvider

class LoginViewModel : ViewModel() {
    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean>
        get() = _isLoggedIn

    fun login(username: String, password: String) {
        _isLoggedIn.value = LoginProvider.validateCredentials(username, password)
    }
}