package com.napas.domain.usecase

import com.napas.domain.repository.CurrencyRepository

class GetCurrenciesUseCase(private val currencyRepository: CurrencyRepository) {
    suspend operator fun invoke() = currencyRepository.getCurrencies()
}