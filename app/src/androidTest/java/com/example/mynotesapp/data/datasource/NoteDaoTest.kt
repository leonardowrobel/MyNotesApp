package com.example.mynotesapp.data.datasource

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.mynotesapp.domain.model.Note
import com.example.mynotesapp.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
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
        val note = Note("Note Title to insert", "Note content to insert.", System.currentTimeMillis(), id = 1)

        dao.insertNote(note)
        val allNotes = dao.observeAllNotes().getOrAwaitValue()

        assertThat(allNotes).contains(note)
    }

    @Test
    fun deleteNote() = runTest {
        val note = Note("Note Title to remove", "Note content to remove.", System.currentTimeMillis(), id = 1)

        dao.insertNote(note)
        dao.deleteNote(note)

        val allNotes = dao.observeAllNotes().getOrAwaitValue()

        assertThat(allNotes).doesNotContain(note)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getNotes() = runTest {
        val noteA = Note("Note A Title to get", "Note A content to get.", System.currentTimeMillis(), id = 1)
        val noteB = Note("Note B Title to get", "Note B content to get.", System.currentTimeMillis(), id = 2)

        dao.insertNote(noteA)
        dao.insertNote(noteB)

        backgroundScope.launch(UnconfinedTestDispatcher(testScheduler)) {
            dao.getNotes().collect{
                assertThat(it).containsExactly(noteA, noteB).inOrder()
            }
        }
    }
}