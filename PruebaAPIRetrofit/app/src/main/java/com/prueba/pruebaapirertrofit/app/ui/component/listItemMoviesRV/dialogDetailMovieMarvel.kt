package com.prueba.pruebaapirertrofit.app.ui.component.listItemMoviesRV

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.prueba.pruebaapirertrofit.app.data.models.Result

@Composable
fun dialogDetailMovieMarvel(
    isDetailSelectedMovie: List<Result>,
    show: Boolean,
    onDismiss: () -> Unit,
) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            Column(
                Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Top,
                Alignment.CenterHorizontally
            )
            {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "close app",
                        modifier = Modifier
                            .align(Alignment.Bottom)
                            .clickable { onDismiss() })
                }

                bodyDialogDetail(isDetailSelectedMovie)
            }
        }
    }

}


@Composable
fun bodyDialogDetail(isDetailSelectedMovie: List<Result>) {

    isDetailSelectedMovie.forEach { deatils ->

        doTitle(deatils.title)
        Text(text = "Inicio: ${deatils.startYear} - Termino:  ${deatils.endYear}", textAlign = TextAlign.Justify)

        doDivider()

        doTitle("Creadores")

        deatils.creators.items.forEach {
            Text(
                text = "*. ${it.name} - (${it.role})",
                fontSize = 14.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier.fillMaxWidth()
            )
        }

        doDivider()
        doTitle("Comics")
        doComics(deatils = deatils)
        doDivider()
        doTitle("Comics")
        doStories(deatils = deatils)
    }
}

@Composable
fun doTitle(name: String){
    Text(
        text = name,
        fontWeight = FontWeight.ExtraBold,
        textAlign = TextAlign.Center,
        fontSize = 18.sp,
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
    )
}

@Composable
fun doDivider(){
    Divider(
        Modifier
            .background(Color(0xFF7C7C7C))
            .height(4.dp)
            .padding(vertical = 8.dp)
    )
}

@Composable
fun doComics(deatils: Result){
    Text(text = "Cantidad de Comics: ${deatils.comics.available}", textAlign = TextAlign.Center, fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold)

    deatils.comics.items.forEach {
        Text(
            text = "*. ${it.name} ",
            textAlign = TextAlign.Justify,
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth()
        )
    }

}

@Composable
fun doStories(deatils: Result){


    Text(text = "Cantidad de Historias: ${deatils.stories.available}", textAlign = TextAlign.Center, fontSize = 16.sp,
        fontWeight = FontWeight.SemiBold)

    deatils.stories.items.forEach {
        Text(
            text = "*. ${it.name} ",
            textAlign = TextAlign.Justify,
            fontSize = 14.sp,
            modifier = Modifier.fillMaxWidth()
        )
    }

}