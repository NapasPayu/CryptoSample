package com.napas.repository.mapper

import com.napas.domain.model.Currency
import com.napas.local.model.CurrencyEntity

class CurrencyMapper : Mapper<CurrencyEntity, Currency> {
    override fun mapFromEntity(entity: CurrencyEntity): Currency {
        return with(entity) {
            Currency(
                id = id,
                name = name,
                symbol = symbol
            )
        }
    }
}