package com.example.wishlistapp

import android.content.Context
import androidx.room.Room
import com.example.wishlistapp.data.WishDatabase
import com.example.wishlistapp.data.WishRepository


//The object is a class that only declare one object of type Graph in this case.
object Graph {

    lateinit var database: WishDatabase

    //the by the lazy variable is done by lazy meaning variable will be initialised when the application loads
    val wishRepository by  lazy {
        WishRepository(wishDao = database.wishDao())
    }

    fun provide(context: Context){
        database = Room.databaseBuilder(context, WishDatabase::class.java, "wishList.db").build()
    }

}