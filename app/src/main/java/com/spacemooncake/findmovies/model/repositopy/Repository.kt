package com.spacemooncake.findmovies.model.repositopy

import com.spacemooncake.findmovies.model.entities.Film

interface Repository {
    fun getFilmsFromServer(): List<Film>
    fun getFilmsFromLocalStorage(): List<Film>
}