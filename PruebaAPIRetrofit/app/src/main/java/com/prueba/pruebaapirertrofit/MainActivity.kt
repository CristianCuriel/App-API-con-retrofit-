package com.prueba.pruebaapirertrofit

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.lifecycleScope
import com.prueba.pruebaapirertrofit.app.data.network.MovieService
import com.prueba.pruebaapirertrofit.app.ui.MovieViewModel
import com.prueba.pruebaapirertrofit.app.ui.moviesViews
import com.prueba.pruebaapirertrofit.core.network.RetrofitHelper
import com.prueba.pruebaapirertrofit.ui.theme.PruebaAPIRertrofitTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PruebaAPIRertrofitTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    moviesViews(MovieViewModel())
                }
            }
        }
    }
}
