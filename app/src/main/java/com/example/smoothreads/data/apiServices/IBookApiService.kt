package com.example.smoothreads.data.apiServices

import com.example.smoothreads.DTOs.Book.AddBookDto
import com.example.smoothreads.DTOs.Book.BookDto
import com.example.smoothreads.DTOs.Book.UpdateBookDto
import com.example.smoothreads.data.models.Book
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface IBookApiService
{
    @GET("books")
    suspend fun getAllBookAsync(): List<BookDto>
    @GET("genre/{genre}")
    suspend fun getBooksByGenreAsync(@Path("genre")genre : String): List<Book>
    @GET("id/{id}")
    suspend fun getBooksByIdAsync(@Path("id")id : Int): BookDto?
    @POST
    suspend fun addBookAsync(book: AddBookDto): Book
    @PUT
    suspend fun updateBookAsync(bookId : Int, updatedBook : UpdateBookDto): Book?
    @DELETE
    suspend fun deleteBookAsync(bookId : Int): Book?
    suspend fun bookExists(bookId : Int): Boolean

}