package com.example.smoothreads.models

data class Read(
    var id : Int,
    var userId: Int,
    var user: User?,
    var bookId : Int,
    var book : Book?
)
