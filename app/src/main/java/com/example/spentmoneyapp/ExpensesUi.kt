package com.example.spentmoneyapp

import android.widget.TextView

data class ExpensesUi(private val name: String, private val amount: Int) :
    Mapper<Boolean, ExpensesUi> {
    fun <T> map(mapper: Mapper<T>): T = mapper.map(name, amount)

    interface Mapper<T> {
        fun map(name: String, amount: Int): T
    }

    override fun map(source: ExpensesUi): Boolean {
        return source.name == name
    }
}

class ListItemUi(
    private val head: TextView,
    private val subTitle: TextView
) :
    ExpensesUi.Mapper<Unit> {
    override fun map(name: String, amount: Int) {
        head.text = name
        subTitle.text = amount.toString()
    }
}