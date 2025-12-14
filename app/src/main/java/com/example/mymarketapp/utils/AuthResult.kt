package com.example.mymarketapp.utils

sealed class AuthResult {
    object EmptyName : AuthResult()
    object EmptyEmail : AuthResult()
    object InvalidEmail : AuthResult()
    object EmptyPassword : AuthResult()
    object ShortPassword : AuthResult()
    object PasswordMismatch : AuthResult()
    object Success : AuthResult()
}