package com.example.primerparcialdelvallerodriguezmariapaula.repository

import androidx.lifecycle.LiveData
import com.example.primerparcialdelvallerodriguezmariapaula.data.StoreDao
import com.example.primerparcialdelvallerodriguezmariapaula.model.Store


class StoreRepository(private val storeDao: StoreDao) {
    //GetAllData es una variable de un método//
    //Crear lista de objetos de tipo Store//
    val getAllData: LiveData<List<Store>> = storeDao.getAlData()

    //Manda un instancia al storeDao que nos permite tener la comunicación final de la Base de Datos//
    suspend fun addStore(store: Store) {
        storeDao.addStore(store)
    }
    //Manda un instancia al storeDao que nos permite tener la comunicación final de la Base de Datos solo que con update//
    suspend fun updateStore(store: Store) {
        storeDao.updateStore(store)
    }
    //Manda un instancia al storeDao que nos permite tener la comunicación final de la Base de Datos solo que con delete//
    suspend fun deleteStore(store: Store) {
        storeDao.deleteStore(store)
    }
}