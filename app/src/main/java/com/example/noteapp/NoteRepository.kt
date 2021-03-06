package com.example.noteapp

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDAO) {
    val allNotes:LiveData<List<NoteEntity>> =noteDao.getAllNotes()

    suspend fun insert(noteEntity: NoteEntity){
        noteDao.insert(noteEntity)
    }

    suspend fun delete(noteEntity:NoteEntity){
        noteDao.delete(noteEntity)
    }
}