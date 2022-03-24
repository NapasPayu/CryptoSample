package com.napas.cryptosample.base

import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import com.napas.cryptosample.model.AlertEvent
import com.napas.cryptosample.util.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {
    val loadingEvent by lazy { SingleLiveEvent<Boolean>() }
    val alertEvent by lazy { SingleLiveEvent<AlertEvent>() }

    protected fun alert(message: String? = null, @StringRes messageRes: Int? = null) {
        alertEvent.value = AlertEvent(
            message = message,
            messageRes = messageRes
        )
    }

    protected fun showLoading() {
        loadingEvent.value = true
    }

    protected fun hideLoading() {
        loadingEvent.value = false
    }
}