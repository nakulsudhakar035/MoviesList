package com.nakuls.movieslist.viewModel

import com.nakuls.movieslist.model.MoviesList
import com.nakuls.movieslist.util.RetrofitInstance
import retrofit2.Response

class Repository {
    suspend fun getMoviesList(page:Int): Response<MoviesList>{
        return RetrofitInstance.api.getMovies(page)
    }
}