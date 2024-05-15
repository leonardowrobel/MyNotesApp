package com.example.mynotesapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
    var title: String,
    var content: String,
    val createdAt: Long,
    @PrimaryKey(autoGenerate = true) val id: Long = 0
)