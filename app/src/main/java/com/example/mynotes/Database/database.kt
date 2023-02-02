package com.example.mynotes.Database

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract  class database:RoomDatabase() {
    abstract fun dao():dao
    companion object{
        @Volatile
        private var INSTANCE: database?=null

        fun getDatabase(context: Context): database{
            if (INSTANCE==null){
                synchronized(this){
                INSTANCE=Room.databaseBuilder(context.applicationContext,database::class.java,"user-notes").allowMainThreadQueries() .build()
            } }
         return  INSTANCE!!}
    }
}