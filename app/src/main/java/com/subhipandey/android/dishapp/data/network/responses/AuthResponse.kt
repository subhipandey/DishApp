package com.subhipandey.android.dishapp.data.network.responses

import com.subhipandey.android.dishapp.data.database.entities.User

class AuthResponse(
    val isSuccessFul : Boolean?,
    val message: String?,
    val user: User?
)