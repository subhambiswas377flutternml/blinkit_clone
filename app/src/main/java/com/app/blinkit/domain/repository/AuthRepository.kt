package com.app.blinkit.domain.repository

import com.app.blinkit.data.entity.request.AuthRequest
import com.app.blinkit.domain.model.AuthModel

interface AuthRepository{
    suspend fun signUp(authRequest: AuthRequest): AuthModel
    suspend fun getAuthCreds(): AuthModel
}