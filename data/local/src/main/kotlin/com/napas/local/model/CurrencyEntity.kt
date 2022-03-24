package com.napas.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class CurrencyEntity(
    @PrimaryKey val id: String,
    val name: String,
    val symbol: String,
)
