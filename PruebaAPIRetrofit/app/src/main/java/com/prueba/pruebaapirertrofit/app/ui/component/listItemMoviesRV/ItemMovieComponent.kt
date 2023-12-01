package com.prueba.pruebaapirertrofit.app.ui.component.listItemMoviesRV

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.pruebaapirertrofit.app.data.models.Result


@Composable
fun itemMovieComponent(movie: Result, onItemSelected: (Result) -> Unit) {

    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .clickable { onItemSelected(movie) }
    ) {

        Column(Modifier.fillMaxWidth()) {
            Text(
                text = movie.title, fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 4.dp)
            )

            Divider(
                Modifier
                    .background(Color(0xFF797979))
                    .height(2.dp)
                    .fillMaxWidth()
                    .padding(vertical = 1.dp)
            )


            Box(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.medium)
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(200.dp)
            ){
                imageMovieComponent(movie.thumbnail)
            }

            Divider(
                Modifier
                    .background(Color(0xFF797979))
                    .height(2.dp)
                    .fillMaxWidth()
                    .padding(vertical = 1.dp)
            )

            Text(
                text = "${movie.startYear}",
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(text = movie.description?.takeIf { it.isNotEmpty() }
                ?: "Descripción no disponible",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp)

        }// Column

    } // ElevatedCard


} //itemMovieComponent

