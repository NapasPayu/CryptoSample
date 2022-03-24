package com.napas.domain.repository

import com.napas.domain.model.Currency

interface CurrencyRepository {
    suspend fun getCurrencies(): Result<List<Currency>>
}