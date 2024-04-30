package com.example.mynotesapp.common

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class MyNotesViewModel: ViewModel() {

//    private val state: MutableLiveData
//        get() {
//            TODO()
//        }

    abstract fun getInitialState()
    abstract fun init()
}