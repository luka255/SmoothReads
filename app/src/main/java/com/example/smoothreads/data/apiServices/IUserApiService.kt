package com.example.smoothreads.data.apiServices

import com.example.smoothreads.DTOs.User.CreateUserDto
import com.example.smoothreads.data.models.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface IUserApiService {
    @GET
    suspend fun getAllAsync() : List<User>
    @GET("id/{id}")
    suspend fun getUserByIdAsync(@Path("id") id : Int) : User
    @GET("email/{email}")
    suspend fun getUserByEmail(@Path("email")email : String) : User
    @POST
    suspend fun addUserAsync(@Body newUser : CreateUserDto) : User
    suspend fun userExist(userId : Int) : Boolean
}