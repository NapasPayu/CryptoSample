package com.napas.local.di

import androidx.room.Room
import com.napas.local.AppDatabase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localModule = module {
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "CryptoSample.db")
            .createFromAsset("database/prepopulate.db")
            .build()
    }
    single { get<AppDatabase>().currencyDao() }
}