package com.example.smoothreads.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smoothreads.DTOs.UserBooks.AddReadDto
import com.example.smoothreads.DTOs.UserBooks.AddWantToReadDto
import com.example.smoothreads.data.models.Read
import com.example.smoothreads.data.models.WantToRead
import com.example.smoothreads.data.repositories.UserBooksRepository
import kotlinx.coroutines.launch
import okio.IOException

class UserBooksViewModel(private val userBookRepo : UserBooksRepository) : ViewModel() {

    private val _wtrBooks = MutableLiveData<List<WantToRead>>()
    val wtrBooks : LiveData<List<WantToRead>> get() = _wtrBooks

    private val _readBooks = MutableLiveData<List<Read>>()
    val readBooks : LiveData<List<Read>> get() = _readBooks

    private val _error = MutableLiveData<ErrorState?>()
    val error : LiveData<ErrorState?> get() = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> get() = _loading

    private val _emptyState = MutableLiveData<Boolean>()
    val emptyState : LiveData<Boolean> get() = _emptyState

    fun fetchWantToReadBooks(userId : Int){
        _loading.value = true
        viewModelScope.launch {
            try {
                val wtrList = userBookRepo.getWantToReadBooks(userId)

                if(wtrList.isEmpty())
                    _emptyState.value = true

                _emptyState.value = false
                _wtrBooks.value = wtrList
            }catch (e: Exception){
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError =  e is IOException
                )
            }finally {
                _loading.value = false
            }
        }
    }

    fun fetchReadBooks(userId : Int){
        _loading.value = true
        viewModelScope.launch {
            try {
                val rList = userBookRepo.getReadBooks(userId)

                if(rList.isEmpty())
                    _emptyState.value = true

                _emptyState.value = false
                _readBooks.value = rList
            }catch (e: Exception){
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError =  e is IOException
                )
            }finally {
                _loading.value = false
            }
        }
    }

    fun addWantToReadBooks(wantToReadDto : AddWantToReadDto){
        _loading.value = true
        viewModelScope.launch {
            try {
                val newWtr = userBookRepo.addWantToReadBooks(wantToReadDto)
                val updatedList = _wtrBooks.value?.toMutableList() ?: mutableListOf()

                updatedList.add(newWtr)
                _wtrBooks.value = updatedList
            }catch (e: Exception){
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError =  e is IOException
                )
            }finally {
                _loading.value = false
            }
        }
    }

    fun addReadBooks(readDto : AddReadDto){
        _loading.value = true
        viewModelScope.launch {
            try {
                val newR = userBookRepo.addReadBooks(readDto)
                val updatedList = _readBooks.value?.toMutableList() ?: mutableListOf()

                updatedList.add(newR)
                _readBooks.value = updatedList
            }catch (e: Exception){
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError =  e is IOException
                )
            }finally {
                _loading.value = false
            }
        }
    }

    fun deleteWantToReadBooks(userId : Int, bookId : Int){
        _loading.value = true
        viewModelScope.launch {
            try {
                val deletedWtr = userBookRepo.deleteWantToReadBook(userId,bookId)
                deletedWtr?.let {
                    val updatedList = _wtrBooks.value?.toMutableList() ?: mutableListOf()
                    updatedList.remove(deletedWtr)
                    _wtrBooks.value = updatedList
                } ?: run {
                    _error.value = ErrorState(message = "deletion failed", isNetworkError = false)
                }
            }catch (e: Exception){
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError =  e is IOException
                )
            }finally {
                _loading.value = false
            }
        }
    }

    fun deleteReadBooks(userId : Int, bookId : Int){
        _loading.value = true
        viewModelScope.launch {
            try {
                val deletedR = userBookRepo.deleteReadBook(userId,bookId)
                deletedR?.let {
                    val updatedList = _readBooks.value?.toMutableList() ?: mutableListOf()
                    updatedList.remove(deletedR)
                    _readBooks.value = updatedList
                } ?: run {
                    _error.value = ErrorState(message = "deletion failed", isNetworkError = false)
                }
            }catch (e: Exception){
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError =  e is IOException
                )
            }finally {
                _loading.value = false
            }
        }
    }
}