package com.example.smoothreads.models

import java.time.LocalDateTime

data class Comment(
    var id : Int,
    var userId : Int,
    var user : User?,
    var bookId : Int,
    var book : Book?,
    var text : String,
    var createAt : LocalDateTime = LocalDateTime.now(),
    var rating : Float
)
