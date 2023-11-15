package com.example.spentmoneyapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class ExpensesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_expenses, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<ImageButton>(R.id.imageButton)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = ExpensesAdapter()
        val expensesList = mutableListOf<ExpensesUi>()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        button.setOnClickListener {
            Log.d("adapter add", "element added")
            expensesList.add(ExpensesUi("some expense", Random.nextInt()))
            adapter.data(expensesList)
        }
    }
}