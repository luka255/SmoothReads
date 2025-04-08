package com.example.smoothreads.DTOs.Favourites

import com.example.smoothreads.DTOs.Book.BookDto
import com.example.smoothreads.DTOs.User.UserDto

data class FavouriteDto(
    var id : Int = 0,
    var userId : Int = 0,
    var bookId : Int = 0,
    var user : List<UserDto>,
    var book : List<BookDto>
)
