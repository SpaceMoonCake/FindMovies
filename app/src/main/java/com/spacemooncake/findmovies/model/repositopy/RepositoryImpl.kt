package com.spacemooncake.findmovies.model.repositopy

import com.spacemooncake.findmovies.model.entities.Film

class RepositoryImpl : Repository {
    override fun getFilmsFromServer() = listOf(
        Film(),
        Film(),
        Film(),
        Film(),
        Film()
    )

    override fun getFilmsFromLocalStorage()  = listOf(
        Film(),
        Film(),
        Film(),
        Film(),
        Film()
    )
}