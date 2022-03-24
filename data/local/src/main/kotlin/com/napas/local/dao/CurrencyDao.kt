package com.napas.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.napas.local.model.CurrencyEntity

@Dao
interface CurrencyDao {
    @Query("SELECT * FROM currency")
    suspend fun getAll(): List<CurrencyEntity>
}