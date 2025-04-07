package com.example.smoothreads.DTOs.Book

data class UpdateBookDto(
    var title: String = "",
    var author: String = "",
    var genre: String = "",
    var description: String = "",
    var publicationYear: Int = 0,
    var rating: Float = 0.0f,
    var imageUrl: String = ""
)
