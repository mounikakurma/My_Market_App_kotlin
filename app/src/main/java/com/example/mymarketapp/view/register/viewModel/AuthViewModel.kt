package com.example.mymarketapp.view.register.viewModel

import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.example.mymarketapp.utils.AuthResult

class AuthViewModel: ViewModel() {
    fun validateSignup(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ): AuthResult {

        if (name.isEmpty()) {
            return AuthResult.EmptyName
        }

        if (email.isEmpty()) {
            return AuthResult.EmptyEmail
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return AuthResult.InvalidEmail
        }

        if (password.isEmpty()) {
            return AuthResult.EmptyPassword
        }

        if (password.length < 6) {
            return AuthResult.ShortPassword
        }

        if (password != confirmPassword) {
            return AuthResult.PasswordMismatch
        }

        return AuthResult.Success
    }
}
