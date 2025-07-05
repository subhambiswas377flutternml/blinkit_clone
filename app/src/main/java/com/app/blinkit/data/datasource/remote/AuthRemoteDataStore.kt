package com.app.blinkit.data.datasource.remote

import com.app.blinkit.core.EndPointsCollection
import com.app.blinkit.data.entity.request.AuthRequest
import com.app.blinkit.data.entity.response.api.AuthApiDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface AuthRemoteDataStore{
    @POST(EndPointsCollection.signUp)
    suspend fun signUp(
        @Body authRequestBody: AuthRequest,
        @Query("key") apiKey:String = "AIzaSyBP0Epqi9ki826ja1YEv9PQ_w_HSlh1QyU"
    ): Response<AuthApiDto>
}