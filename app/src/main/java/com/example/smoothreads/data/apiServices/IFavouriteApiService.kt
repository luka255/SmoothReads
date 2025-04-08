package com.example.smoothreads.data.apiServices

import com.example.smoothreads.DTOs.Favourites.AddFavouriteDto
import com.example.smoothreads.DTOs.Favourites.FavouriteDto
import com.example.smoothreads.data.models.Favourite
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST

interface IFavouriteApiService {

    @GET("userId/{userId}")
    suspend fun getFavouritesByUserIdAsync(userId : Int) : List<FavouriteDto>
    @POST("{userId}/{bookId}")
    suspend fun addFavouritesAsync(favouriteDto : AddFavouriteDto) : Favourite
    @DELETE
    suspend fun removeFavouritesAsync(userId : Int, bookId : Int) : Favourite

}