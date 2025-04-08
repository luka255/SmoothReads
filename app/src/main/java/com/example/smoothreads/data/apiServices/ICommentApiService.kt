package com.example.smoothreads.data.apiServices

import com.example.smoothreads.data.models.Comment
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface ICommentApiService {

    @GET
    suspend fun getAllCommentsAsync() : List<Comment>
    @GET("byBook/{bookId}")
    suspend fun getCommentByBookIdAsync(bookId : Int) : List<Comment>
    @GET("byId/{id}")
    suspend fun getCommentByIdAsync(id : Int) : List<Comment>
    @POST("{userId}/{bookId}")
    suspend fun addCommentAsync(commentModel : Comment) : Comment
    @DELETE
    suspend fun deleteCommentAsync(commentId : Int) : Comment
}