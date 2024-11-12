package com.nakuls.movieslist.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nakuls.movieslist.model.Data
import com.nakuls.movieslist.model.Details
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {

    private val repository = Repository()
    var state by mutableStateOf(ScreenState())

    init {
        viewModelScope.launch {
            try {
                val response = repository.getMoviesList(state.page)
                state = state.copy(
                    movies = response.body()!!.data
                )
            } catch (e: Exception) {

            }
        }
    }
}

data class ScreenState(
    val movies: List<Data> = emptyList(),
    val page: Int = 1,
    val detailsData: Details = Details()
)