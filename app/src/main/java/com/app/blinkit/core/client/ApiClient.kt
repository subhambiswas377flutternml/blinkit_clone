package com.app.blinkit.core.client

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient{
    lateinit var retrofitInstance: Retrofit
    fun initRetrofit(){
        retrofitInstance = Retrofit.Builder().baseUrl(
            "https://identitytoolkit.googleapis.com/v1/"
        ).addConverterFactory(GsonConverterFactory.create()).build()
    }

    inline fun <reified T> provideDataSource(): T{
        return retrofitInstance.create(T::class.java)
    }
}