package com.napas.currencylist.di

import com.napas.currencylist.CurrencyListFragment
import com.napas.currencylist.CurrencyListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val currencyListModule = module {
    scope<CurrencyListFragment> {
        viewModel { CurrencyListViewModel(get()) }
    }
}