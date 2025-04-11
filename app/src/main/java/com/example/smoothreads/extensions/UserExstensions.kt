package com.example.smoothreads.extensions

import com.example.smoothreads.DTOs.User.CreateUserDto
import com.example.smoothreads.DTOs.User.UserDto

fun CreateUserDto.toUserDto() : UserDto{
    return UserDto(
        name = this.name,
        email = this.email
    )
}