package com.example.mynotesapp.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun HomeFragment(viewModel: HomeViewModel){
    val homeUiState by viewModel.uiState.collectAsState()

}