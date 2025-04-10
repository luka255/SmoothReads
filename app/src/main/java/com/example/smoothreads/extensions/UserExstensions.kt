package com.example.smoothreads.extensions

import com.example.smoothreads.DTOs.User.UserDto
import com.example.smoothreads.data.models.User

fun User.toUserDto() : UserDto{
    return UserDto(
        name = this.name,
        email = this.email
    )
}