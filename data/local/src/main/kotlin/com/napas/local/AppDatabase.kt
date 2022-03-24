package com.napas.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.napas.local.dao.CurrencyDao
import com.napas.local.model.CurrencyEntity

@Database(
    entities = [CurrencyEntity::class],
    version = 1,
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
}
