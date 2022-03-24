package com.napas.domain.di

import com.napas.domain.usecase.GetCurrenciesUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetCurrenciesUseCase(get()) }
}