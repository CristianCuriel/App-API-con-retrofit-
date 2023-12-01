package com.prueba.pruebaapirertrofit.app.data.network

import android.net.http.HttpException
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresExtension
import androidx.lifecycle.MutableLiveData
import com.prueba.pruebaapirertrofit.app.data.models.Result
import com.prueba.pruebaapirertrofit.core.network.RetrofitHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieService {

    private val retrofit = RetrofitHelper.getRetrofit()

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    suspend fun doGetMovie(): List<Result> {
        val error = MutableLiveData<Throwable>()

        return withContext(Dispatchers.IO) {
            try {
                val response = retrofit.create(RetrofitService::class.java).doPelisMarvel()
                return@withContext response.data.results
            } catch (e: HttpException) {
                Log.e("MovieService", "Error al cargar la lista de películas", e)
                error.value = e
                throw e
            } catch (e: Throwable) {
                Log.e("MovieService", "Error desconocido", e)
                error.value = e
                throw e
            }
        }
    }

}