package com.example.primerparcialdelvallerodriguezmariapaula.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.primerparcialdelvallerodriguezmariapaula.data.StoreDatabase
import com.example.primerparcialdelvallerodriguezmariapaula.model.Store
import com.example.primerparcialdelvallerodriguezmariapaula.repository.StoreRepository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StoreViewModel(application: Application) : AndroidViewModel(application) {
    val getAllData: LiveData<List<Store>>

    //Hace referencia al repositorio que funciona como intermediario//
    private val repository: StoreRepository

    init { //init me funciona para inicializar, funciona como el constructor en java//
        val storeDao = StoreDatabase.getDatabase(application).storeDao()
        repository = StoreRepository(storeDao)
        getAllData = repository.getAllData
    }

    //método de add store//
    fun addStore(store: Store) {
        viewModelScope.launch(Dispatchers.IO) { repository.addStore(store) }
    }
    //método de update store//
    fun updateStore(store: Store) {
        viewModelScope.launch(Dispatchers.IO) { repository.updateStore(store) }
    }

    //método de delete store//
    fun deleteStore(store: Store) {
        viewModelScope.launch(Dispatchers.IO) { repository.deleteStore(store) }
    }
}