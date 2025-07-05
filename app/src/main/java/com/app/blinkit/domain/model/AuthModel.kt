package com.app.blinkit.domain.model

data class AuthModel(
    val kind:String?,
    val localId:String?,
    val email:String?,
    val displayName:String?,
    val idToken:String?,
    val registered:Boolean?,
    val refreshToken:String?,
    val expiresIn:String?,
)