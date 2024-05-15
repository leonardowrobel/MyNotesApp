package com.example.mynotesapp.ui.home

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
    private val _uiState = MutableStateFlow(HomeState())
    val uiState: StateFlow<HomeState> = _uiState.asStateFlow()

    companion object {
        const val TAG: String = "HOME_VM"
    }
}