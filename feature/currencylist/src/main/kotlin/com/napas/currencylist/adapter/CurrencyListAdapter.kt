package com.napas.currencylist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.napas.currencylist.databinding.ListItemCurrencyBinding
import com.napas.domain.model.Currency

class CurrencyListAdapter(
    private val onCLick: (Currency) -> Unit,
) : ListAdapter<Currency, CurrencyListAdapter.ViewHolder>(CurrencyDiffCallback) {

    inner class ViewHolder(private val binding: ListItemCurrencyBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private var currentCurrency: Currency? = null

        init {
            binding.root.setOnClickListener {
                currentCurrency?.let {
                    onCLick(it)
                }
            }
        }

        fun bind(currency: Currency) {
            with(currency) {
                currentCurrency = this
                binding.name.text = name
                binding.symbol.text = symbol
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemCurrencyBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

object CurrencyDiffCallback : DiffUtil.ItemCallback<Currency>() {
    override fun areItemsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Currency, newItem: Currency): Boolean {
        return oldItem == newItem
    }
}