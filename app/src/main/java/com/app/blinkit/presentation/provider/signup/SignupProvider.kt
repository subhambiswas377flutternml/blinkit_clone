package com.app.blinkit.presentation.provider.signup

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.blinkit.data.entity.request.AuthRequest
import com.app.blinkit.domain.model.AuthModel
import com.app.blinkit.domain.usecase.SignupUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SignupViewModel(private val signupUseCase: SignupUseCase = SignupUseCase()): ViewModel(){
    private val privateState: MutableState<SignupState> = mutableStateOf<SignupState>(value = SignupState.Initial)
    val state: State<SignupState> = privateState
        get(){
            return field
        }

    private val signupExceptionHandler = CoroutineExceptionHandler{coroutineContext, throwable->
        privateState.value = SignupState.Error(ex = throwable as? Exception)
        println("Log : ${throwable.message}")
    }


    fun signUp(email: String, password: String){
        viewModelScope.launch(signupExceptionHandler) {
            privateState.value = SignupState.Loading
            withContext(Dispatchers.IO){
                val authData: AuthModel = signupUseCase(authRequest = AuthRequest(email = email, password = password))
                privateState.value = SignupState.Loaded(authData = authData)
            }
        }
    }
}