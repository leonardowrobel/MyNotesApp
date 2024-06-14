package com.example.mynotesapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mynotesapp.domain.model.Note
import com.example.mynotesapp.ui.theme.MyNotesAppTheme
import dagger.hilt.android.AndroidEntryPoint
import com.example.mynotesapp.ui.home.HomeScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyNotesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen()
                }
            }
        }
    }
}

@Composable
fun MainPage(
    notes: List<Note>,
    noteTitle: String,
    onChangeNoteTitle: (String) -> Unit,
    noteContent: String,
    onChangeNoteContent: (String) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(Color.DarkGray)
        ) {
            Column {
                Header()
                Column {
                    BasicTextField(
                        value = noteTitle,
                        onValueChange = onChangeNoteTitle
                    )
                }
                NotesPresenter(notes = notes)
            }
        }
    }
}

@Composable
fun Header(text: String = " My Notes App") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .padding(16.dp)
    ) {
        Icon(
            imageVector = Icons.Default.List,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .height(36.dp)
        )
        Text(
            text = text,
            color = Color.White,
            fontSize = 24.sp
        )
    }
}

@Composable
fun NoteCreator() {
    Column {
//        OutlinedTextField(value = , onValueChange = )
    }
}

@Composable
fun NotesPresenter(notes: List<Note>) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
    ) {
        items(notes) { note ->
            Column {
                Text(
                    color = Color.White,
                    text = note.title
                )
            }
            // TODO: implement Note(note)
        }
    }
}

@Composable
fun Note(note: Note) {
// TODO
}

@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    val values = listOf(
        Note("Title A", "Content A", System.currentTimeMillis()),
        Note("Title B", "Content B", System.currentTimeMillis()),
        Note("Title C", "Content C", System.currentTimeMillis())
    )

    var noteTitle by remember {
        mutableStateOf("")
    }

    fun changeTitle(value: String) {
        noteTitle = value
    }

    var noteContent by remember {
        mutableStateOf("")
    }
    var notes by remember {
        mutableStateOf(listOf<Note>())
    }

//    MainPage(values, noteTitle, )
}