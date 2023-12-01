package com.prueba.pruebaapirertrofit.app.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prueba.pruebaapirertrofit.app.data.models.Result
import com.prueba.pruebaapirertrofit.app.data.models.Thumbnail
import com.prueba.pruebaapirertrofit.app.data.network.MovieService
import kotlinx.coroutines.launch

class MovieViewModel: ViewModel() {

    private var _movieList = MutableLiveData<List<Result>>(emptyList())
    val movieList: LiveData<List<Result>> = _movieList

    //private var _imageViewMovie = MutableLiveData<List<Thumbnail>>(emptyList())
    //val imageViewMovie: LiveData<List<Thumbnail>> = _imageViewMovie

    private var _isDetailSelectedMovie = MutableLiveData<List<Result>>(emptyList())
    val isDetailSelectedMovie: LiveData<List<Result>> = _isDetailSelectedMovie

    private var _isLoading = MutableLiveData<Boolean>()
    var isLoading:LiveData<Boolean> = _isLoading

    private val movieService = MovieService()

    fun onMovie(){
        viewModelScope.launch {
            val result = movieService.doGetMovie()
            _movieList.value = result

        }
    }//onMovie

    fun onGetDeatilsMovie(M: Result) {
        _isDetailSelectedMovie.value = listOf(M)
        _isLoading.value = true
    }

}