package com.napas.repository.di

import com.napas.domain.repository.CurrencyRepository
import com.napas.repository.CurrencyRepositoryImpl
import com.napas.repository.mapper.CurrencyMapper
import org.koin.dsl.module

val repositoryModule = module {
    single { CurrencyMapper() }
    single<CurrencyRepository> { CurrencyRepositoryImpl(get(), get()) }
}