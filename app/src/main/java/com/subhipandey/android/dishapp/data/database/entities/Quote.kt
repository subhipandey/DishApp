package com.subhipandey.android.dishapp.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Quote (
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val quote: String,
    val author: String,
    val thumbnail: String,
    val created_at: String,
    val updated_at: String
)