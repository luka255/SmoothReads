package com.example.smoothreads.data.apiServices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL =  "http://10.0.2.2:5250/api/"

    val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val IBookApiService: IBookApiService by lazy{
        retrofit.create(IBookApiService::class.java)
    }

    val ICommentApiService: ICommentApiService by lazy{
        retrofit.create(ICommentApiService::class.java)
    }
    val IUserApiService: ICommentApiService by lazy{
        retrofit.create(IUserApiService::class.java)
    }
    val IFavouriteApiService: ICommentApiService by lazy{
        retrofit.create(IFavouriteApiService::class.java)
    }
    val IUserBooksApiService: ICommentApiService by lazy{
        retrofit.create(IUserBooksApiService::class.java)
    }

}