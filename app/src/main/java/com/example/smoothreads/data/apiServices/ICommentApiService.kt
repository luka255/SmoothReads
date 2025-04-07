package com.example.smoothreads.data.apiServices

import com.example.smoothreads.data.models.Comment
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ICommentApiService {

    @GET
    suspend fun GetAllCommentsAsync() : List<Comment>
    @GET("bookId/{bookId}")
    suspend fun GetCommentByBookIdAsync(@Path("bookId")bookId : Int) : List<Comment>
    @GET("id/{id}")
    suspend fun GetCommentByIdAsync(@Path("id")id : Int) : List<Comment>
    @POST
    suspend fun AddCommentAsync(commentModel : Comment) : Comment
    @DELETE
    suspend fun DeleteCommentAsync(commentId : Int) : Comment
}