package com.example.smoothreads.DTOs.Auth

data class RegisterRequest(
    val name : String,
    val email : String,
    val password : String
)
