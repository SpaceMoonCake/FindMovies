package com.spacemooncake.findmovies.data.repositopy

import com.spacemooncake.findmovies.domain.entities.Film

interface Repository {
    fun getFilmsFromServer(): List<Film>
    fun getFilmsFromLocalStorage(): List<Film>
}