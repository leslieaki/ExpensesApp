package com.example.spentmoneyapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
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

    fun data(list: MutableList<ExpensesUi>) {
        val diff = DiffUtilCallback(expensesList, list)
        val result = DiffUtil.calculateDiff(diff)
        expensesList.clear()
        expensesList.addAll(list)
        expensesList.reverse()
        result.dispatchUpdatesTo(this)
    }
}

class ExpensesViewHolder(item: View) : ViewHolder(item) {
    private val name = itemView.findViewById<TextView>(R.id.nameTextView)
    private val price = itemView.findViewById<TextView>(R.id.priceTextView)
    fun bind(model: ExpensesUi) {
        model.map(ListItemUi(name, price))
    }
}

class DiffUtilCallback(
    private val oldList: List<ExpensesUi>,
    private val newList: List<ExpensesUi>,
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].map(newList[newItemPosition])

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition] == newList[newItemPosition]
}



