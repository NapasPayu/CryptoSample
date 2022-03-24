package com.napas.cryptosample.base

import com.google.android.material.snackbar.Snackbar
import com.napas.cryptosample.R
import com.napas.cryptosample.model.AlertEvent
import org.koin.androidx.scope.ScopeFragment

abstract class BaseFragment : ScopeFragment() {

    protected fun showAlert(alertEvent: AlertEvent) {
        view?.let {
            Snackbar.make(
                it,
                alertEvent.message ?: alertEvent.messageRes?.let(this::getString)
                ?: getString(R.string.generic_error),
                Snackbar.LENGTH_LONG
            ).show()
        }
    }
}