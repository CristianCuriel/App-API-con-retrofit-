package com.prueba.pruebaapirertrofit.app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.prueba.pruebaapirertrofit.app.data.models.Result
import com.prueba.pruebaapirertrofit.app.data.models.Thumbnail
import com.prueba.pruebaapirertrofit.app.data.network.MovieService
import com.prueba.pruebaapirertrofit.app.ui.component.listItemMoviesRV.viewListMovie


@Composable
fun moviesViews(movieViewModel: MovieViewModel) {

    val movieList: List<Result> by movieViewModel.movieList.observeAsState(initial = emptyList())

    Box(
        Modifier
            .fillMaxSize()
            .padding(2.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                buttonCallMovie(movieViewModel = movieViewModel)
            }//ROW
            viewListMovie(movieViewModel = movieViewModel, movieList)
        }//Column

    }
}//moviesViews

@Composable
fun buttonCallMovie(movieViewModel: MovieViewModel) {


    Button(
        onClick = {
            movieViewModel.onMovie()
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primary),
        colors = ButtonDefaults.textButtonColors(
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
    ) {
        Text("Obtener Movies", fontWeight = FontWeight.Bold)
    }
}



