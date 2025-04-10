package com.example.smoothreads.viewmodels

import com.example.smoothreads.extensions.toUserDto
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smoothreads.DTOs.User.CreateUserDto
import com.example.smoothreads.DTOs.User.UserDto
import com.example.smoothreads.data.repositories.UserRepository
import kotlinx.coroutines.launch
import okio.IOException

class UserViewModel (private val userRepo : UserRepository) : ViewModel(){

    private val _users = MutableLiveData<List<UserDto>>()
    val users : LiveData<List<UserDto>> get() = _users

    private val _error = MutableLiveData<ErrorState?>()
    val error : LiveData<ErrorState?> get() = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> get() = _loading

    private val _emptyState = MutableLiveData<Boolean>()
    val emptyState : LiveData<Boolean> get() = _emptyState

    fun fetchAllUsers(){
        _loading.value = true
        viewModelScope.launch {
            try {
                val usersList = userRepo.getAll()

                if(usersList.isEmpty())
                    _emptyState.value = true

                _users.value = usersList
                _emptyState.value = false
            }catch (e : Exception){
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError =  e is IOException
                )
            }finally {
                _loading.value = false
            }
        }
    }

    fun fetchUserDetail(userId : Int){
        _loading.value = true
        viewModelScope.launch {
            try {
                val userModel = userRepo.getUserById(userId)
                _users.value = if (userModel != null) listOf(userModel) else emptyList()
            }catch (e : Exception){
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError =  e is IOException
                )
            }finally {
                _loading.value = false
            }
        }
    }

    fun fetchUserByEmail(email : String){
        _loading.value = true
        viewModelScope.launch {
            try {
                val userModel = userRepo.getUserByEmail(email)
                _users.value = if (userModel != null) listOf(userModel) else emptyList()
            }catch (e : Exception){
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError =  e is IOException
                )
            }finally {
                _loading.value = false
            }
        }
    }

    fun addUser(newUser : CreateUserDto ){
        _loading.value = true
        viewModelScope.launch {
            try {
                val user =  userRepo.addUser(newUser)
                val updatedList = _users.value?.toMutableList() ?: mutableListOf()
                updatedList.add(newUser.toUserDto())
                _users.value = updatedList
            }catch (e : Exception){
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