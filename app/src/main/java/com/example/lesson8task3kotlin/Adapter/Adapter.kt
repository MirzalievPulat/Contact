package com.example.lesson8task3kotlin.Adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson8task3kotlin.Contact
import com.example.lesson8task3kotlin.Fragments.FirstFragment
import com.example.lesson8task3kotlin.Fragments.SecondFragment
import com.example.lesson8task3kotlin.R
import kotlinx.android.synthetic.main.contact_litem.view.*

class Adapter(var fragmentManager: FragmentManager?, var contactList: ArrayList<Contact>) :
    RecyclerView.Adapter<Adapter.VH>() {

    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun onBind(contact: Contact) {

            itemView.contact_name.text = contact.name
            itemView.phone_number.text = contact.number
            itemView.setOnClickListener {

                val secondFragment = SecondFragment()
                val bundle = Bundle()
                bundle.putSerializable("contact", Contact(contact.name, contact.number))
                secondFragment.arguments = bundle
                fragmentManager?.beginTransaction()?.addToBackStack(FirstFragment().toString())
                    ?.replace(com.google.android.material.R.id.container, secondFragment)?.commit()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.contact_litem, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(contactList[position])
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}