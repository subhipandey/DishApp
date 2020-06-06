package com.subhipandey.android.dishapp.ui.auth

import androidx.lifecycle.LiveData
import com.subhipandey.android.dishapp.data.database.entities.User

interface AuthListener {
    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message: String)
}