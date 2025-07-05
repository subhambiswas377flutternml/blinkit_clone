package com.app.blinkit.data.repository

import AuthLocalDataSource
import com.app.blinkit.core.client.ApiClient
import com.app.blinkit.core.util.DatabaseInitiator
import com.app.blinkit.data.datasource.remote.AuthRemoteDataStore
import com.app.blinkit.data.entity.request.AuthRequest
import com.app.blinkit.domain.model.AuthModel
import com.app.blinkit.domain.repository.AuthRepository

class AuthRepositoryImpl(
    private val authRemoteDataSource: AuthRemoteDataStore = ApiClient.provideDataSource<AuthRemoteDataStore>(),
    private val authLocalDataSource: AuthLocalDataSource = DatabaseInitiator.authLocalDataSource,
): AuthRepository{
    override suspend fun signUp(authRequest: AuthRequest): AuthModel{
        try{
            val authData = authRemoteDataSource.signUp(authRequestBody = authRequest)
            if(authData.code()==200&&authData.body()!=null){
                val authModelData = authLocalDataSource.insert(authData = authData.body()!!.toCacheDto())
                return authModelData
            }else{
                throw java.lang.Exception("Data fetching error!")
            }
        }catch(ex: Exception){
            throw ex
        }
    }


    override suspend fun getAuthCreds(): AuthModel{
        return authLocalDataSource.read()
    }
}