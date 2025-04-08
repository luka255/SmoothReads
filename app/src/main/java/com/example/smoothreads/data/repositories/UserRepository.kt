package com.example.smoothreads.data.repositories

import com.example.smoothreads.DTOs.User.CreateUserDto
import com.example.smoothreads.data.apiServices.IUserApiService
import com.example.smoothreads.data.models.User

class UserRepository(private val api : IUserApiService) {

    suspend fun getAll() : List<User>{
        return api.getAllAsync()
    }

    suspend fun  getUserById(id : Int) : User{
        return api.getUserByIdAsync(id)
    }

    suspend fun getUserByEmail(email : String) : User{
        return api.getUserByEmail(email)
    }

    suspend fun addUser(newUser : CreateUserDto) : User{
        return api.addUserAsync(newUser)
    }

    suspend fun userExist(userId : Int) : Boolean{
        return api.userExist(userId)
    }
}