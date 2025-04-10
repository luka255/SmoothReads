package com.example.smoothreads.viewmodels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smoothreads.DTOs.Book.AddBookDto
import com.example.smoothreads.DTOs.Book.BookDto
import com.example.smoothreads.data.repositories.BookRepository
import com.example.smoothreads.extensions.toBookDto
import kotlinx.coroutines.launch
import okio.IOException

class BookViewModel (private val bookRepo : BookRepository) : ViewModel() {

    private val _books = MutableLiveData<List<BookDto>>()
    val books : LiveData<List<BookDto>> get() = _books

    private val _error = MutableLiveData<ErrorState?>()
    val error : LiveData<ErrorState?> get() = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> get() = _loading

    private val _emptyState = MutableLiveData<Boolean>()
    val emptyState : LiveData<Boolean> get() = _emptyState

    fun fetchAllBooks(){
        _loading.value = true
        viewModelScope.launch {
            try {
                val bookList = bookRepo.getAllBooks()

                if(bookList.isEmpty())
                    _emptyState.value = true

                _books.value = bookList
                _emptyState.value = false
            }catch (e: Exception){
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError =  e is IOException
                )
            } finally {
                _loading.value = false
            }
        }
    }

    fun fetchBooksByGenre(genre : String){
        _loading.value = true
        viewModelScope.launch {
            try {
                val bookList = bookRepo.getBooksByGenre(genre)
                if(bookList.isEmpty())
                    _emptyState.value = true

                _emptyState.value = false
                _books.value = bookList.map { it.toBookDto() }
            }catch (e : Exception){
                _error.value = ErrorState(e.localizedMessage, e is IOException)
            }finally {
                _loading.value = false
            }
        }
    }

    fun fetchBookDetail(bookId : Int){
        _loading.value = true
        viewModelScope.launch {
            try {
                val book = bookRepo.getBookById(bookId)
                _books.value = if (book != null) listOf(book) else emptyList()
            }catch (e : Exception){
                _error.value = ErrorState(e.localizedMessage, e is IOException)
            }finally {
                _loading.value = false
            }
        }
    }

    fun addBook(book : AddBookDto){
        _loading.value = true
        viewModelScope.launch {
            try {
                val newBook = bookRepo.addBook(book)
                val updatedList = _books.value?.toMutableList() ?: mutableListOf()
                updatedList.add(newBook.toBookDto())
                _books.value = updatedList
            }catch (e: Exception){
                _error.value = ErrorState(e.localizedMessage, e is IOException)
            }finally {
                _loading.value = false
            }
        }
    }

    fun deleteBook(bookId : Int){
        _loading.value = true
        viewModelScope.launch {
            try {
                val deletedBook = bookRepo.deleteBook(bookId)
                deletedBook?.let {
                    val updatedList = _books.value?.toMutableList() ?: mutableListOf()
                    updatedList.remove(it.toBookDto())
                    _books.value = updatedList
                } ?: run{
                    _error.value = ErrorState(message = "Book deletion failed", isNetworkError = false)
                }
            }catch (e : Exception){
                _error.value = ErrorState(e.localizedMessage, e is IOException)
            }finally {
                _loading.value = false
            }
        }
    }

    fun bookExists(bookId : Int) : Boolean{
        var exists = false
        viewModelScope.launch {
            try {
               exists = bookRepo.bookExists(bookId)
            }catch (e : Exception) {
               exists = false
            }
        }
        return exists
    }

    fun clearError(){
        _error.value = null
    }
}

data class ErrorState(val message: String?, val isNetworkError: Boolean)