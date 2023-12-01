package com.prueba.pruebaapirertrofit.app.ui.component.listItemMoviesRV

import android.text.Layout
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.LiveData
import com.prueba.pruebaapirertrofit.app.data.models.Result
import com.prueba.pruebaapirertrofit.app.ui.MovieViewModel


@Composable
fun viewListMovie(movieViewModel: MovieViewModel, movieList: List<Result>) {
    val context = LocalContext.current
    var show by rememberSaveable { mutableStateOf(false) }
    val isDetailSelectedMovie: List<Result> by movieViewModel.isDetailSelectedMovie.observeAsState(
        initial = emptyList()
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(movieList) { movie ->
            itemMovieComponent(movie) { M ->
                movieViewModel.onGetDeatilsMovie(M)
                println(M.id)
                show = true
            }
        }
    }

    dialogDetailMovieMarvel(isDetailSelectedMovie, show, onDismiss = { show = false })
}




