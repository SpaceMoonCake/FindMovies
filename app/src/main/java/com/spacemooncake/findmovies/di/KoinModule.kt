package com.spacemooncake.findmovies

import com.spacemooncake.findmovies.data.repositopy.Repository
import com.spacemooncake.findmovies.data.repositopy.RepositoryImpl
import com.spacemooncake.findmovies.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single<Repository> { RepositoryImpl() }
    viewModel { MainViewModel(get()) }
}