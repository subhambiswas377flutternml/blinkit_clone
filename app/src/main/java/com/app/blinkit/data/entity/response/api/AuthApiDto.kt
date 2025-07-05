package com.app.blinkit.data.entity.response.api

import com.app.blinkit.data.entity.response.cache.AuthCacheDto

class AuthApiDto(
    val kind:String?,
    val localId:String?,
    val email:String?,
    val displayName:String?,
    val idToken:String?,
    val registered:Boolean?,
    val refreshToken:String?,
    val expiresIn:String?,
){
    fun toCacheDto():AuthCacheDto{
        return AuthCacheDto(
            kind = kind,
            localId = localId,
            email = email,
            displayName= displayName,
            idToken = idToken,
            registered = registered,
            refreshToken = refreshToken,
            expiresIn = expiresIn,
        )
    }
}