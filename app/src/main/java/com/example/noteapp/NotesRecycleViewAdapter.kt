package com.example.noteapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRecycleViewAdapter(private val context:Context, private val listener : InotesRVAdapter) : RecyclerView.Adapter<NotesRecycleViewAdapter.NoteViewHolder>() {

    private val allNotes = ArrayList<NoteEntity>()


    inner class NoteViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val textView: TextView ? = itemView.findViewById<TextView>(R.id.tvItemLayout)
        val deleteButton: ImageView = itemView.findViewById<ImageView>(R.id.deleteButton)
        fun bind(text: String?) {
            if (textView != null) {
                textView.text = text
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.item_note,parent,false))
        viewHolder.deleteButton.setOnClickListener {
            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
       val currentNote= allNotes[position]
        holder.textView?.text = currentNote.text
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateList(newList: List<NoteEntity>){
        allNotes.clear()
        allNotes.addAll(newList)
        notifyDataSetChanged()
    }
}

interface InotesRVAdapter{
    fun onItemClicked(note:NoteEntity)
}