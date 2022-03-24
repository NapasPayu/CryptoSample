package com.napas.currencylist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.napas.cryptosample.model.AlertEvent
import com.napas.cryptosample.util.TestCoroutineRule
import com.napas.domain.model.Currency
import com.napas.domain.usecase.GetCurrenciesUseCase
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyOrder
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class CurrencyListViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private val getCurrenciesUseCase: GetCurrenciesUseCase = mockk()
    private val fakeCurrencies = listOf(
        Currency(
            id = "BTC",
            name = "Bitcoin",
            symbol = "BTC"
        ),
        Currency(
            id = "CRO",
            name = "Crypto.com",
            symbol = "CRO"
        ),
        Currency(
            id = "XRP",
            name = "XRP",
            symbol = "XRP"
        )
    )
    private val fakeSortedCurrencies = fakeCurrencies.sortedBy(Currency::name)

    private lateinit var viewModel: CurrencyListViewModel

    @Before
    fun setUp() {
        viewModel = CurrencyListViewModel(getCurrenciesUseCase)
    }

    @Test
    fun `get currencies and sort`() = runBlockingTest {
        // arrange
        coEvery { getCurrenciesUseCase() } returns Result.success(fakeCurrencies)

        val observer = mockk<Observer<List<Currency>>>(relaxed = true)
        viewModel.currencies.observeForever(observer)

        //act
        viewModel.getCurrencies()
        viewModel.sort()

        // assert
        verifyOrder {
            observer.onChanged(fakeCurrencies)
            observer.onChanged(fakeSortedCurrencies)
        }
    }

    @Test
    fun `get currencies failed`() = runBlockingTest {
        // arrange
        coEvery { getCurrenciesUseCase() } returns Result.failure(Throwable("error"))

        val observer = mockk<Observer<AlertEvent>>(relaxed = true)
        viewModel.alertEvent.observeForever(observer)

        //act
        viewModel.getCurrencies()

        // assert
        verify {
            observer.onChanged(AlertEvent("error"))
        }
    }

}