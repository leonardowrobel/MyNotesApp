package com.example.mynotesapp.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mynotesapp.ui.Header

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
//    val homeUiState by viewModel.uiState.collectAsState()
    val state = viewModel.state.value


    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.DarkGray)
    ) {
        Column {
            Header()
            Column {
                OutlinedTextField(
                    value = state.testing,
                    onValueChange = {
                        state.testing = it
                    }
                )
//                OutlinedTextField(
//                    value = newNoteContent,
//                    onValueChange = {
//                        newNoteContent = it
//                    }
//                )
//                                Button(onClick = { /*TODO*/ }) {
//
//                                }
                Text(text = state.testing)
            }
//            NotesPresenter(notes = notes)
        }
    }


}