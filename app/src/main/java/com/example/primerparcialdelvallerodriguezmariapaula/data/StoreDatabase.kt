package com.example.primerparcialdelvallerodriguezmariapaula.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.primerparcialdelvallerodriguezmariapaula.model.Store


@Database(entities = [Store::class], version = 1, exportSchema = false)
abstract class StoreDatabase: RoomDatabase() {
    abstract fun storeDao(): StoreDao

    companion object {
        @Volatile
        private var INSTANCE: StoreDatabase? = null
        //Para tomar la base de datos//
        fun getDatabase(context: android.content.Context): StoreDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
        //Para hacer la sincronización//
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    StoreDatabase::class.java,
                    "store_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}