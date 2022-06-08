package com.spacemooncake.findmovies.model.entities

import com.spacemooncake.findmovies.R
import java.util.*

data class Film(
    val filmId: String = "12sf32467",
    val filmName: String = "Невероятный фильм",
    var filmDescription: String = "Действительно невероятный фильм",
    var filmRating: Double = 4.3,
    val filmDate: String = "21.10.2020",
    var filmPoster: Int = R.drawable.poster_example2
)
