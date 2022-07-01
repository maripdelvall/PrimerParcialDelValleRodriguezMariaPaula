package com.example.primerparcialdelvallerodriguezmariapaula.data

import androidx.lifecycle.LiveData
import androidx.room.*

import com.example.primerparcialdelvallerodriguezmariapaula.model.Store

@Dao
interface StoreDao {

    @Query("SELECT * FROM STORE")
    fun getAlData(): LiveData<List<Store>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addStore(store: Store)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateStore(store: Store)

    @Delete
    suspend fun deleteStore(store: Store)
}