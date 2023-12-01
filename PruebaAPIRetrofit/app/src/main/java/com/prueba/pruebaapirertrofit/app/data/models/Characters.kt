package com.prueba.pruebaapirertrofit.app.data.models

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)