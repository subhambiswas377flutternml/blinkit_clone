package com.app.blinkit.presentation.provider.signup

import com.app.blinkit.domain.model.AuthModel

sealed class SignupState{
    data object Initial:SignupState()
    data object Loading:SignupState()
    data class Loaded(val authData: AuthModel): SignupState()
    data class Error(val ex: Exception?): SignupState()
}

fun SignupState.isLoading(): Boolean{
    return when(this){
        SignupState.Loading-> {
            true
        }else->{
            false
        }
    }
}