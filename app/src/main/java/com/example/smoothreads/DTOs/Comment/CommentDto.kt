package com.example.smoothreads.DTOs.Comment

import java.util.Date

data class CommentDto(
    var id: Int = 0,
    var bookId: Int = 0,
    var text: String = "",
    var createdAt: Date = Date(),
    var rating: Float = 0.0f

)
