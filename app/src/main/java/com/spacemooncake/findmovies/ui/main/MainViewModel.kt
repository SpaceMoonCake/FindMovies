package com.spacemooncake.findmovies.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.spacemooncake.findmovies.model.AppState
import com.spacemooncake.findmovies.model.repositopy.Repository

class MainViewModel(private val repository: Repository) : ViewModel() {
    private val localLiveData = MutableLiveData<AppState>()
    val liveData: LiveData<AppState> get() = localLiveData
    fun getFilmsFromLocalSource() = getDataFromLocalSource()

    private fun getDataFromLocalSource(){
        localLiveData.value = AppState.Success(repository.getFilmsFromLocalStorage())
    }
}