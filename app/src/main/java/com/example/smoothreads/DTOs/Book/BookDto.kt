package com.example.smoothreads.DTOs.Book

import com.example.smoothreads.DTOs.Comment.CommentDto

data class BookDto(
    var id: Int = 0,
    var title: String = "",
    var author: String = "",
    var genre: String = "",
    var description: String = "",
    var publicationYear: Int = 0,
    var rating: Float = 0.0f,
    var imageUrl: String = "",
    var comments: List<CommentDto> = emptyList()
)
