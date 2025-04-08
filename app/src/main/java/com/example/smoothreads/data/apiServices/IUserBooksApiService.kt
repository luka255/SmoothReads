package com.example.smoothreads.data.apiServices

import com.example.smoothreads.DTOs.UserBooks.AddReadDto
import com.example.smoothreads.DTOs.UserBooks.AddWantToReadDto
import com.example.smoothreads.data.models.Read
import com.example.smoothreads.data.models.WantToRead
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface IUserBooksApiService {
    @GET("WantToRead")
    suspend fun getWantToReadBooksAsync(@Query("userId") userId : Int) : List<WantToRead>
    @GET("Read")
    suspend fun getReadBooksAsync(@Query("userId") userId : Int) : List<Read>
    @POST("want-to-read/{userId}/{bookId}")
    suspend fun addWantToReadBooksAsync(@Path("want-to-Read") wantToReadDto : AddWantToReadDto) : WantToRead
    @POST("read-books/{userId}/{bookId}")
    suspend fun addWReadBooksAsync(@Path("read-books")readDto : AddReadDto) : Read
    @DELETE("want-to-read/{userId}/{bookId}")
    suspend fun deleteWantToReadBookAsync(userId : Int, bookId : Int) : WantToRead
    @DELETE("read-books/{userId}/{bookId}")
    suspend fun deleteReadBookAsync(userId : Int, bookId : Int) : Read
}