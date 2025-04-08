package com.example.smoothreads.data.repositories

import com.example.smoothreads.DTOs.Favourites.AddFavouriteDto
import com.example.smoothreads.DTOs.Favourites.FavouriteDto
import com.example.smoothreads.data.apiServices.IFavouriteApiService
import com.example.smoothreads.data.models.Favourite

class FavouriteRepository (private val api : IFavouriteApiService) {

    suspend fun getFavouritesByUserId(userId : Int) : List<FavouriteDto>{
        return api.getFavouritesByUserIdAsync(userId)
    }

    suspend fun addFacourites(favouriteDto : AddFavouriteDto) : Favourite{
        return api.addFavouritesAsync(favouriteDto)
    }

    suspend fun removeFavourites(userId: Int, bookId : Int) : Favourite{
        return api.removeFavouritesAsync(userId, bookId)
    }
}