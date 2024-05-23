package com.example.wishlistapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wishlistapp.data.DummyWish
import com.example.wishlistapp.data.Wish

@Composable
fun HomeView(
    navController: NavController,
    viewModel: WishViewModel
){


    Scaffold(
        topBar = {AppBarView(title = "WishList", {

        })},
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier.padding(all = 20.dp),onClick = { navController.navigate(Screen.AddScreen.route) },
                contentColor = Color.White,
                backgroundColor = Color.Black
                ) {
Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }

    ) {
        val wishList = viewModel.getAllWishes.collectAsState(initial = listOf())
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(it)){
            items(wishList.value){  Wish ->
                WishItem(wish = Wish) {
                    
                }
            }
        }
    }

}

@Composable
fun WishItem(wish: Wish, onClick: () -> Unit){

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 8.dp, start = 8.dp, end = 8.dp)
        .clickable {
            onClick()
        }, elevation = 10.dp, backgroundColor = Color.White) {
       Column(modifier = Modifier.padding(16.dp)) {
        Text(text = wish.title, fontWeight = FontWeight.ExtraBold)
           Text(text = wish.discription)
       }
    }

}