package com.napas.currencylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.napas.cryptosample.base.BaseFragment
import com.napas.currencylist.adapter.CurrencyListAdapter
import com.napas.currencylist.databinding.FragmentCurrencyListBinding
import com.napas.currencylist.di.currencyListModule
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class CurrencyListFragment : BaseFragment() {

    private lateinit var binding: FragmentCurrencyListBinding
    private val viewModel: CurrencyListViewModel by viewModel()
    lateinit var listAdapter: CurrencyListAdapter

    init {
        loadKoinModules(currencyListModule)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCurrencyListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listAdapter = CurrencyListAdapter {
            Toast.makeText(requireContext(), "Clicked: ${it.symbol}", Toast.LENGTH_SHORT).show()
        }
        binding.recyclerView.adapter = listAdapter
        binding.buttonLoad.setOnClickListener {
            viewModel.getCurrencies()
        }
        binding.buttonSort.setOnClickListener {
            viewModel.sort()
        }

        viewModel.currencies.observe(viewLifecycleOwner) {
            it?.let {
                listAdapter.submitList(it)
            }
        }
        viewModel.loadingEvent.observe(viewLifecycleOwner) {
            it?.let {
                binding.progress.isVisible = it
            }
        }
        viewModel.alertEvent.observe(viewLifecycleOwner) {
            it?.let {
                showAlert(it)
            }
        }
    }
}