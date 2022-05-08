package com.example.lesson8task3kotlin.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.lesson8task3kotlin.Contact
import com.example.lesson8task3kotlin.R
import kotlinx.android.synthetic.main.fragment_second.view.*

class SecondFragment: Fragment() {
    private lateinit var root: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        root = inflater.inflate(R.layout.fragment_second, container, false)
        if (arguments != null) {
            val contact = arguments?.getSerializable("contact") as Contact
            root.contact_name_secondFragment.text = contact.name
            root.contact_number_secondFragment.text = contact.number
        }
        return root
    }
}