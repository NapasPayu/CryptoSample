package com.napas.repository

import com.napas.domain.model.Currency
import com.napas.domain.repository.CurrencyRepository
import com.napas.local.dao.CurrencyDao
import com.napas.repository.mapper.CurrencyMapper

class CurrencyRepositoryImpl(
    private val currencyDao: CurrencyDao,
    private val currencyMapper: CurrencyMapper,
) : CurrencyRepository {
    override suspend fun getCurrencies(): Result<List<Currency>> {
        return runCatching {
            currencyDao.getAll().map(currencyMapper::mapFromEntity)
        }
    }
}