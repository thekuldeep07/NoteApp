package com.example.noteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), InotesRVAdapter {

    lateinit var  viewModel :NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewMA.layoutManager = LinearLayoutManager(this)
        val adapter = NotesRecycleViewAdapter(this,this)
        recyclerViewMA.adapter =adapter

        viewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(
            NoteViewModel::class.java
        )
        viewModel.allNotes.observe(this, Observer { list->

           list?.let {
               adapter.updateList(it)
           }

        })

    }

    override fun onItemClicked(note: NoteEntity) {
        viewModel.deleteNote(note)
        Toast.makeText(this,"Deleted",Toast.LENGTH_SHORT).show()


    }

    fun submitData(view: View) {

        val noteText = inputText.text.toString()
        if (noteText.isNotEmpty()){
            viewModel.insertNote(NoteEntity(noteText))
            Toast.makeText(this,"SUBMITTED",Toast.LENGTH_SHORT).show()
        }

    }
}