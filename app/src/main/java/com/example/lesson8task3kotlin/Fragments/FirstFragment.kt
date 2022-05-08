package com.example.lesson8task3kotlin.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson8task3kotlin.Adapter.Adapter
import com.example.lesson8task3kotlin.Contact
import com.example.lesson8task3kotlin.R
import kotlinx.android.synthetic.main.fragment_first.view.*

class FirstFragment : Fragment() {

    private lateinit var root: View
    lateinit var adapter: Adapter
    lateinit var list: ArrayList<Contact>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        loadData()
        adapter = Adapter(fragmentManager = fragmentManager, list)
        root = inflater.inflate(R.layout.fragment_first, container, false)
        root.rv.adapter = adapter

        return root
    }

    private fun loadData() {
        list = ArrayList()
        for (i in 0..100) {
            list.add(Contact("PDP-$i", "+998 99 $i"))
        }
    }
}