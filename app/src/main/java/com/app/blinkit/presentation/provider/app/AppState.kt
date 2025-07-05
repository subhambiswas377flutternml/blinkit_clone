package com.app.blinkit.presentation.provider.app

import com.app.blinkit.domain.model.AuthModel

sealed class AppState {
    data object Initial: AppState()
    data object Loading: AppState()
    data class Authenticated(val authData: AuthModel): AppState()
    data class UnAuthenticated(val ex: Exception? = null):AppState()
}

fun AppState.isLoading(): Boolean{
    when(this){
        AppState.Loading->{
            return true
        }else->{
            return false
        }
    }
}