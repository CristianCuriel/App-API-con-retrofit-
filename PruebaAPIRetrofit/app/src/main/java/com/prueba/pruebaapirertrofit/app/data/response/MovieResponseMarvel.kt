package com.prueba.pruebaapirertrofit.app.data.response

import com.google.gson.annotations.SerializedName
import com.prueba.pruebaapirertrofit.app.data.models.RemoteResult
import com.prueba.pruebaapirertrofit.app.data.models.Result

data class MovieResponseMarvel (
     var results: List<RemoteResult>
    )