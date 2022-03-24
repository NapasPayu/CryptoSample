package com.napas.currencylist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.napas.cryptosample.base.BaseViewModel
import com.napas.domain.model.Currency
import com.napas.domain.usecase.GetCurrenciesUseCase
import kotlinx.coroutines.launch

class CurrencyListViewModel(
    private val getCurrenciesUseCase: GetCurrenciesUseCase,
) : BaseViewModel() {

    val currencies = MutableLiveData<List<Currency>>()

    fun getCurrencies() {
        showLoading()
        viewModelScope.launch {
            getCurrenciesUseCase()
                .onSuccess {
                    currencies.value = it
                }
                .onFailure {
                    alert(it.message.toString())
                }
            hideLoading()
        }
    }

    fun sort() {
        currencies.value = currencies.value?.sortedBy(Currency::symbol)
    }
}