package com.example.mynotesapp.data.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mynotesapp.data.model.Note
import com.example.mynotesapp.data.model.NoteDao

@Database(
    entities = [Note::class], version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        private const val DB_NAME = "Notes-Database.db"

        // Get reference of the LanguageDatabase and assign it null value
        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        // create an operator fun which has context as a parameter
        // assign value to the instance variable
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

        // create a buildDatabase function assign the required values
        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            DB_NAME
        ).fallbackToDestructiveMigration().build()
    }
}