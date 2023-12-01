package com.prueba.pruebaapirertrofit.app.data.network

import com.prueba.pruebaapirertrofit.app.data.models.RemoteResult
import com.prueba.pruebaapirertrofit.core.constantes.API_KEY
import com.prueba.pruebaapirertrofit.core.constantes.HASH
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("v1/public/series?")

    suspend fun doPelisMarvel(
        @Query("ts") timestamp: Long = 1,
        @Query("orderBy") orderBy: String = "title",
        @Query("apikey") apikey: String = API_KEY,
        @Query("hash") hash: String = HASH
    ): RemoteResult //Response<MovieResponseMarvel>
}