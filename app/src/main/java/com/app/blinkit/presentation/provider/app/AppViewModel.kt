package com.app.blinkit.presentation.provider.app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.blinkit.data.repository.AuthRepositoryImpl
import com.app.blinkit.domain.model.AuthModel
import com.app.blinkit.domain.repository.AuthRepository
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AppViewModel(
    private val authRepository: AuthRepository = AuthRepositoryImpl()
): ViewModel() {
    private val privateAppState: MutableState<AppState> = mutableStateOf<AppState>(value = AppState.Initial)
    val state: State<AppState> = privateAppState
        get(){
            return field
        }
    private val handler = CoroutineExceptionHandler{coroutineContext, throwable->
        privateAppState.value = AppState.UnAuthenticated(ex = throwable as? Exception)
    }

    fun checkAuthentication(){
        viewModelScope.launch(handler) {
            withContext(Dispatchers.IO){
                val localData = authRepository.getAuthCreds()
                privateAppState.value = AppState.Authenticated(authData = localData)
            }
        }
    }

    fun authenticate(authData: AuthModel){
        privateAppState.value = AppState.Authenticated(authData = authData)
    }
}