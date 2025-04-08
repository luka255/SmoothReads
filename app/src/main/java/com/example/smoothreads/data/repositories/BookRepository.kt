package com.example.smoothreads.data.repositories

import com.example.smoothreads.DTOs.Book.AddBookDto
import com.example.smoothreads.DTOs.Book.BookDto
import com.example.smoothreads.DTOs.Book.UpdateBookDto
import com.example.smoothreads.data.apiServices.IBookApiService
import com.example.smoothreads.data.models.Book

class BookRepository(private val api: IBookApiService) {

    suspend fun  getAllBooks() : List<BookDto>{
        return api.getAllBookAsync()
    }

    suspend fun getBooksByGenre(genre : String) : List<Book>{
        return api.getBooksByGenreAsync(genre)
    }

    suspend fun  getBookById(id : Int) : BookDto? {
        return api.getBooksByIdAsync(id)
    }

    suspend fun addBook(bookDto : AddBookDto) : Book {
        return api.addBookAsync(bookDto)
    }

    suspend fun deleteBook(bookId : Int, updateBookDto: UpdateBookDto) : Book? {
        return api.updateBookAsync(bookId, updateBookDto)
    }

    suspend fun bookExists(bookId: Int) : Boolean {
        return api.bookExists(bookId)
    }
}