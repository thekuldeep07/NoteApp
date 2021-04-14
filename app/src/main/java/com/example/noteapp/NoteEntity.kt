package com.example.noteapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//this class is used to create entity for room database

@Entity(tableName = "notes_table")
class NoteEntity(@ColumnInfo(name = "note_Text")var text:String)
{
    @PrimaryKey(autoGenerate = true)var id :Int =0

}