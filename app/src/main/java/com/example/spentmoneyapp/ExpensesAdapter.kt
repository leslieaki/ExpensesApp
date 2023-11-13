package com.example.spentmoneyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.spentmoneyapp.databinding.ExpenseLayoutBinding

class ExpensesAdapter : RecyclerView.Adapter<ExpensesViewHolder>() {

    private val expensesList = mutableListOf<ExpensesUi>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpensesViewHolder =
        ExpensesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.expense_layout, parent, false)
        )

    override fun onBindViewHolder(holder: ExpensesViewHolder, position: Int) {
        holder.bind(expensesList[position])
    }

    override fun getItemCount(): Int = expensesList.size

    fun add(item:ExpensesUi) {
        expensesList.add(item)
        notifyDataSetChanged()
    }
}

class ExpensesViewHolder(item: View) : ViewHolder(item) {
    private val binding = ExpenseLayoutBinding.bind(item)
    fun bind(model: ExpensesUi) = with(binding) {
        nameTextView.text = model.name
        priceTextView.text = model.amount.toString()
    }
}


