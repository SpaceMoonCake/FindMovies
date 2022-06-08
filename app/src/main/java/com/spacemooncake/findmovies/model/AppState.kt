package com.spacemooncake.findmovies.model

import com.spacemooncake.findmovies.model.entities.Film

sealed class AppState {
    data class Success(val filmData: List<Film>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
