package com.example.mynotesapp.ui.home

import com.example.mynotesapp.domain.model.Note

data class HomeState (
    val notes: List<Note> = emptyList(),
    var testing: String = "Testing"
)