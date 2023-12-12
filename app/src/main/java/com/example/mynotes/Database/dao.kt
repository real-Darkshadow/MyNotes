package com.example.mynotes.Database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface dao {

    @Insert
    suspend fun insertNote(user: User)

    @Delete
    suspend fun deleteNote(user: User)

    @Update
    suspend fun updateNote(user: User)

    @Query("SELECT * FROM notes")
    fun getnote(): List<User>


    @Query("SELECT * FROM notes WHERE headline LIKE :searchQuery")
    fun searchNotes(searchQuery: String): List<User>


}