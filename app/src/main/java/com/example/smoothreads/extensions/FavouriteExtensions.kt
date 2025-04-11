package com.example.smoothreads.extensions

import com.example.smoothreads.DTOs.Book.BookDto
import com.example.smoothreads.DTOs.Favourites.FavouriteDto
import com.example.smoothreads.DTOs.User.UserDto
import com.example.smoothreads.data.models.Favourite
import kotlin.collections.List

fun Favourite.toFavouriteDto() : FavouriteDto{
    return FavouriteDto(
        user = this.user?.toUserDto(),
        book = this.book?.toBookDto()
    )
}