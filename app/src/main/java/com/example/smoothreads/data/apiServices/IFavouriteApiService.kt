package com.example.smoothreads.data.apiServices

import com.example.smoothreads.DTOs.Favourites.AddFavouriteDto
import com.example.smoothreads.data.models.Favourite
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface IFavouriteApiService {

    @GET("userId/{userId}")
    suspend fun getFavouritesByUserIdAsync(@Path("userId") userId : Int) : List<Favourite>
    @POST("{userId}/{bookId}")
    suspend fun addFavouritesAsync(favouriteDto : AddFavouriteDto) : Favourite
    @DELETE
    suspend fun removeFavouritesAsync(@Query("userId") userId : Int,@Query("bookId") bookId : Int) : Favourite

}