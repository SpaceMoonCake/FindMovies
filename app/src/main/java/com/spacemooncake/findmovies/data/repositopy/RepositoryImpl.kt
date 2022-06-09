package com.spacemooncake.findmovies.data.repositopy

import com.spacemooncake.findmovies.domain.entities.Film

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