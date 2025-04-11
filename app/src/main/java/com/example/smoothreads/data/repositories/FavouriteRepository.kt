package com.example.smoothreads.data.repositories

import com.example.smoothreads.DTOs.Favourites.AddFavouriteDto
import com.example.smoothreads.data.apiServices.IFavouriteApiService
import com.example.smoothreads.data.models.Favourite

class FavouriteRepository (private val api : IFavouriteApiService) {

    suspend fun getFavouritesByUserId(userId : Int) : List<Favourite>{
        return api.getFavouritesByUserIdAsync(userId)
    }

    suspend fun addFavourites(favouriteDto : AddFavouriteDto) : Favourite{
        return api.addFavouritesAsync(favouriteDto)
    }

    suspend fun removeFavourites(userId: Int, bookId : Int) : Favourite{
        return api.removeFavouritesAsync(userId, bookId)
    }
}