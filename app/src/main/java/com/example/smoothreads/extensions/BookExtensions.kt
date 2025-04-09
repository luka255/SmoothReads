package com.example.smoothreads.extensions

import com.example.smoothreads.DTOs.Book.BookDto
import com.example.smoothreads.data.models.Book


fun Book.toBookDto(): BookDto {
    return BookDto(
        title = this.title,
        author = this.author,
        genre = this.genre,
        description = this.description,
        publicationYear = this.publicationYear,
        rating = this.rating,
        imageUrl = this.imageUrl
    )
}
