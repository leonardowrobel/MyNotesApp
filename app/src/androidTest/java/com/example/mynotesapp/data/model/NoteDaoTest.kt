package com.example.mynotesapp.data.model

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.mynotesapp.data.datasource.AppDatabase
import com.example.mynotesapp.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class NoteDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: AppDatabase
    private lateinit var dao: NoteDao

    @Before
    fun setup(){
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.noteDao()
    }

    @After
    fun teardown(){
        database.close()
    }

    @Test
    fun insertNote() = runTest {
        val note = Note("Note Title", "Note content.", System.currentTimeMillis(), id = 1)
        dao.insertNote(note)

        val allNotes = dao.observeAllNotes().getOrAwaitValue()

        assertThat(allNotes).contains(note)
    }
}