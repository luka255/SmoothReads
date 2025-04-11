package com.example.smoothreads.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smoothreads.DTOs.Favourites.AddFavouriteDto
import com.example.smoothreads.data.models.Favourite
import com.example.smoothreads.data.repositories.FavouriteRepository
import kotlinx.coroutines.launch
import okio.IOException

class FavouriteViewModel(private val favouriteRepo : FavouriteRepository) : ViewModel() {

    private val _favourite = MutableLiveData<List<Favourite>>()
    val favourite: LiveData<List<Favourite>> get() = _favourite

    private val _error = MutableLiveData<ErrorState?>()
    val error: LiveData<ErrorState?> get() = _error

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _emptyState = MutableLiveData<Boolean>()
    val emptyState: LiveData<Boolean> get() = _emptyState


    fun fetchFavouriteByUserId(userId: Int) {
        _loading.value = true
        viewModelScope.launch {
            try {
                val favourite = favouriteRepo.getFavouritesByUserId(userId)

                if (favourite.isEmpty())
                    _emptyState.value = true

                _emptyState.value = false
                _favourite.value = favourite
            } catch (e: Exception) {
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError = e is IOException
                )
            } finally {
                _loading.value = false
            }
        }
    }

    fun addFavourites(favouriteDto: AddFavouriteDto) {
        _loading.value = true
        viewModelScope.launch {
            try {
                val newFav = favouriteRepo.addFavourites(favouriteDto)
                val updatedList = _favourite.value?.toMutableList() ?: mutableListOf()

                updatedList.add(newFav)
                _favourite.value = updatedList
            } catch (e: Exception) {
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError = e is IOException
                )
            } finally {
                _loading.value = false
            }
        }
    }

    fun deleteFavourite(userId : Int, bookId : Int){
        _loading.value = true
        viewModelScope.launch {
            try {
                val deletedFav = favouriteRepo.removeFavourites(userId,bookId)
                deletedFav?.let {
                    val updatedList = _favourite.value?.toMutableList() ?: mutableListOf()
                    updatedList.remove(deletedFav)
                    _favourite.value = updatedList
                } ?: run {
                    _error.value = ErrorState(message = "favourite delation failed", isNetworkError = false)
                }
            } catch (e: Exception) {
                _error.value = ErrorState(
                    message = e.localizedMessage,
                    isNetworkError = e is IOException
                )
            } finally {
                _loading.value = false
            }
        }
    }
}