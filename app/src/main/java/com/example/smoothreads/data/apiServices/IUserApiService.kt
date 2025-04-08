package com.example.smoothreads.data.apiServices

import com.example.smoothreads.DTOs.User.CreateUserDto
import com.example.smoothreads.data.models.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IUserApiService {
    @GET
    suspend fun getAllAsync() : List<User>
    @GET("id/{id}")
    suspend fun getUserByIdAsync(id : Int) : User
    @GET("email/{email}")
    suspend fun getUserByEmail(email : String) : User
    @POST
    suspend fun addUserAsync(@Body newUser : CreateUserDto) : User
    suspend fun userExist(userId : Int) : Boolean
}