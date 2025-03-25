package com.example.smoothreads.models

data class Book(
    var id: Int,
    var title: String = "",
    var author: String ="",
    var description: String="",
    var publicationYear: Int,
    var rating: Float,
    var imageUrl: String = "",

    var comments: MutableList<Comment> = mutableListOf(),
    var reads: MutableList<Read> = mutableListOf(),
    var wantsToReads: MutableList<WantToRead> = mutableListOf(),
    var favourites: MutableList<Favourite> = mutableListOf()
)
