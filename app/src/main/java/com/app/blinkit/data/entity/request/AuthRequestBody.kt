package com.app.blinkit.data.entity.request

data class AuthRequest(
    val email: String,
    val password:String,
    val returnSecureToken: Boolean = true,
)