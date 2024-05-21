package com.example.wishlistapp.data

data class Wish(
    val id: Long = 0L,
    val title: String = "",
    val discription: String = ""
)

object DummyWish{
    val wishList = listOf(
        Wish(title = "Google watch", discription = "Google play"),
        Wish(title = "Google watch", discription = "Google play"),
        Wish(title = "Google watch", discription = "Google play"),
        Wish(title = "Google watch", discription = "Google play")
    )
}
