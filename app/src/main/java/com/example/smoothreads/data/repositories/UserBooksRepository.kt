package com.example.smoothreads.data.repositories

import com.example.smoothreads.DTOs.UserBooks.AddReadDto
import com.example.smoothreads.DTOs.UserBooks.AddWantToReadDto
import com.example.smoothreads.data.apiServices.IUserBooksApiService
import com.example.smoothreads.data.models.Read
import com.example.smoothreads.data.models.WantToRead

class UserBooksRepository(private val api : IUserBooksApiService){

    suspend fun getWantToReadBooks(userId : Int) : List<WantToRead>{
        return api.getWantToReadBooksAsync(userId)
    }

    suspend fun getReadBooks(userId : Int) : List<Read>{
        return api.getReadBooksAsync(userId)
    }

    suspend fun addWantToReadBooks(wantToReadDto : AddWantToReadDto) : WantToRead{
        return api.addWantToReadBooksAsync(wantToReadDto)
    }

    suspend fun addReadBooks(readDto : AddReadDto) : Read{
        return api.addReadBooksAsync(readDto)
    }

    suspend fun deleteWantToReadBook(userId : Int, bookId : Int) : WantToRead{
        return api.deleteWantToReadBookAsync(userId,bookId)
    }

    suspend fun deleteReadBook(userId : Int, bookId : Int) : Read{
        return api.deleteReadBookAsync(userId,bookId)
    }
}