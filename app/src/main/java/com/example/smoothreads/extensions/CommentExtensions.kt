package com.example.smoothreads.extensions

import com.example.smoothreads.DTOs.Comment.CommentDto
import com.example.smoothreads.data.models.Comment

fun Comment.toCommentDto() : CommentDto{
    return CommentDto(
        text = this.text,
        createdAt = java.util.Date.from(this.createAt.atZone(java.time.ZoneId.systemDefault()).toInstant()),
        rating = this.rating
    )
}