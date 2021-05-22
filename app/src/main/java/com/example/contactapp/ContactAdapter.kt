package com.example.contactapp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contactapp.databinding.ActivityContactListItemBinding


class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {

    private val contacts = mutableListOf<Contact>()


    fun setupContacts(contacts: List<Contact>){
        this.contacts.addAll(contacts)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
       return ContactViewHolder(ActivityContactListItemBinding.inflate(LayoutInflater.from
       (parent.context),parent,false))
    }

    override fun getItemCount(): Int {
       return contacts.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bindItem(contact)
    }

    inner class ContactViewHolder(private val binding: ActivityContactListItemBinding):RecyclerView.ViewHolder(binding.root){

        fun bindItem(contact: Contact){

            binding.nameTv.text = contact.name
            binding.numberTv.text = contact.number

        }
    }
}