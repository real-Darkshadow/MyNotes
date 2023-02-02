package com.example.mynotes.Database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val headline:String,
    val Note:String
)