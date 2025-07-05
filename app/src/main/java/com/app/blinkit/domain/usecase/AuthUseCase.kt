package com.app.blinkit.domain.usecase

import com.app.blinkit.data.entity.request.AuthRequest
import com.app.blinkit.data.repository.AuthRepositoryImpl
import com.app.blinkit.domain.model.AuthModel
import com.app.blinkit.domain.repository.AuthRepository

class SignupUseCase(private val authRepository: AuthRepository = AuthRepositoryImpl()){
    suspend operator fun invoke(authRequest: AuthRequest): AuthModel{
        return authRepository.signUp(authRequest = authRequest)
    }
}