package com.example.mynotesapp.ui.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mynotesapp.service.NotesService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
//    private val notesService: NotesService
) : ViewModel()  {
    private val _state = mutableStateOf(HomeState())
    val state: State<HomeState> = _state

    companion object {
        const val TAG: String = "HOME_VM"
    }
}