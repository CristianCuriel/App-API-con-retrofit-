package com.prueba.pruebaapirertrofit.core.network

import com.prueba.pruebaapirertrofit.core.constantes
import com.prueba.pruebaapirertrofit.app.data.network.RetrofitService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitHelper{
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(constantes.BASED_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}