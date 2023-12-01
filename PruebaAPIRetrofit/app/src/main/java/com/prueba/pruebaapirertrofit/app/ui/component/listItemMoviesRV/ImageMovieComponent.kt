package com.prueba.pruebaapirertrofit.app.ui.component.listItemMoviesRV

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.prueba.pruebaapirertrofit.app.data.models.Thumbnail


@Composable
fun imageMovieComponent(thumbnail: Thumbnail) {
    val imageUrl = "${thumbnail.path}.${thumbnail.extension}"
    Log.i("imageUrl", imageUrl)

    SubcomposeAsyncImage(
        model = imageUrl,
        contentDescription = ""
    ) {
        val state = painter.state
        if (state is AsyncImagePainter.State.Loading) {

            CircularProgressIndicator(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .align(
                        Alignment.Center
                    )
            )

        }else if(state is AsyncImagePainter.State.Error){
            Toast.makeText(LocalContext.current, "Fallo la carga de la imagen", Toast.LENGTH_SHORT)
                .show()
        }
        else {
            SubcomposeAsyncImageContent()
        }
    }

}

