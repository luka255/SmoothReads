package com.example.smoothreads.data.models

data class Favourite(
    var id : Int,
    var userId : Int,
    var user : User?,
    var bookId : Int,
    var book : Book?
)
