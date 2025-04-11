package com.example.smoothreads.data.repositories

import com.example.smoothreads.data.apiServices.ICommentApiService
import com.example.smoothreads.data.models.Comment

class CommentRepository (private val api : ICommentApiService){

    suspend fun getAllComments() : List<Comment>{
        return api.getAllCommentsAsync()
    }

    suspend fun getCommentByBookId(bookId : Int) : List<Comment>{
        return api.getCommentByBookIdAsync(bookId)
    }

    suspend fun getCommentById(id : Int) : List<Comment>{
        return api.getCommentByIdAsync(id)
    }

    suspend fun addComment(commentModel : Comment) : Comment{
        return api.addCommentAsync(commentModel)
    }

    suspend fun deleteComment(commentId : Int) : Comment? {
        return api.deleteCommentAsync(commentId)
    }
}