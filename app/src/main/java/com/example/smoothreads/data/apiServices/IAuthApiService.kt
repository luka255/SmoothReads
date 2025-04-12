package com.example.smoothreads.data.apiServices

import com.example.smoothreads.DTOs.Auth.LoginRequest
import com.example.smoothreads.DTOs.Auth.RegisterRequest
import com.example.smoothreads.DTOs.Auth.TokenResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface IAuthApiService {
    @POST("auth/login")
    suspend fun login (@Body request : LoginRequest) : TokenResponse

    @POST("auth/register")
    suspend fun register (@Body request: RegisterRequest) : TokenResponse
}