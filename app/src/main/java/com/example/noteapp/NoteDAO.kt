package com.example.noteapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend  fun insert(note:NoteEntity)

    @Delete
    suspend fun delete(note:NoteEntity)

    @Query("Select * From notes_table order by id ASC")
    fun getAllNotes():LiveData<List<NoteEntity>>
}