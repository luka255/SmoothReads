package com.example.smoothreads.models

data class User(
    var id : Int,
    var name : String = "",
    var email : String = "",
    var password : String = "",

    var comments: MutableList<Comment> = mutableListOf(),
    var reads: MutableList<Read> = mutableListOf(),
    var wantsToReads: MutableList<WantToRead> = mutableListOf(),
    var favourites: MutableList<Favourite> = mutableListOf()
    )
