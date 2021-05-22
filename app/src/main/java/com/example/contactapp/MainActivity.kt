package com.example.contactapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.contactapp.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  val  adapter = ContactAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupData(binding)
    }

    private fun setupData(binding: ActivityMainBinding) {
        binding.contactRv.adapter = adapter
        binding.contactRv.addItemDecoration(DividerItemDecoration(this,LinearLayout.VERTICAL))
        val builder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val view = inflater.inflate(R.layout.add_contact_dialog,null)
        builder.setView(view)

        val name = findViewById<TextInputEditText>(R.id.nameEditText)
        val number = findViewById<TextInputEditText>(R.id.numberEditText)
        val  save = findViewById<Button>(R.id.savebtn)

        number.addTextChangedListener{object:TextWatcher{

            override fun afterTextChanged(s: Editable?) {
                TODO("Not yet implemented")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                save.isEnabled = s?.length === 11
            }

        }}

        val alertDialog = builder.create()

        save.setOnClickListener {
            val contact = Contact(name.text.toString(),number.text.toString())
            val contacts = mutableListOf(contact)
            adapter.setupContacts(contacts)
            alertDialog.dismiss()

        }

        binding.fab.setOnClickListener {
            alertDialog.show();
        }





    }

}