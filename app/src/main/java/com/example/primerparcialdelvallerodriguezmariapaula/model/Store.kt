package com.example.primerparcialdelvallerodriguezmariapaula.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "store")
data class Store (
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        @ColumnInfo(name="nombre")
        val nombre: String,
        @ColumnInfo(name="precio")
        val precio: String,
        @ColumnInfo(name="cantidad")
        val cantidad: String,
        @ColumnInfo(name="color")
        val color: String,
        @ColumnInfo(name="descuento")
        val descuento: String,
): Parcelable