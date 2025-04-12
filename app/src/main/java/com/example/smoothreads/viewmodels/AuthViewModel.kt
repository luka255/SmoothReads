package com.example.smoothreads.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smoothreads.DTOs.Auth.LoginRequest
import com.example.smoothreads.DTOs.Auth.RegisterRequest
import com.example.smoothreads.data.apiServices.RetrofitInstance
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val api = RetrofitInstance.IAuthApiService

    private val _token = MutableLiveData<String?>()
    val token: LiveData<String?> get() = _token

    private val _error = MutableLiveData<String?>()
    val error : LiveData<String?> get() = _error

    fun login(email : String, password : String){
        viewModelScope.launch {
            try {
                val response = api.login(LoginRequest(email,password))
                _token.value = response.token
            }catch (e : Exception){
                _error.value = "login failed"
            }
        }
    }

    fun register(name : String, email : String, password : String ){
        viewModelScope.launch {
            try {
                val response = api.register(RegisterRequest(name,email,password))
                _token.value = response.token
            }catch (e : Exception){
                _error.value = "registration failed"
            }
        }
    }

    fun clearError(){
        _error.value = null
    }
}