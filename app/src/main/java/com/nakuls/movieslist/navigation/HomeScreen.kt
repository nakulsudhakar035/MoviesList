package com.nakuls.movieslist.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.nakuls.movieslist.viewModel.MovieViewModel

@Composable
fun HomeScreen(navController: NavHostController) {

    val movieViewModel = viewModel<MovieViewModel>()
    val state = movieViewModel.state
    Scaffold(
        modifier = Modifier.background(Color.Transparent),
        topBar = {
            TopBar()
        },
        content = { paddingValues ->
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .background(
                        Color.Transparent
                    ),
                content = {
                    items(state.movies.size) {
                        ItemUi(
                            itemIndex = it,
                            movieList = state.movies,
                            navController = navController
                        )
                    }
                }
            )
        },
        containerColor = Color.Transparent
    )
}