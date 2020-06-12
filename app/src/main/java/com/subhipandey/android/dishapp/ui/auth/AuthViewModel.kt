package com.subhipandey.android.dishapp.ui.auth

import androidx.lifecycle.ViewModel
import com.subhipandey.android.dishapp.data.database.entities.User
import com.subhipandey.android.dishapp.data.repository.UserRepo

class AuthViewModel(
   private val repository: UserRepo
) : ViewModel() {

  fun getLoggedInUser() = repository.getUser()

    suspend fun userLogin(
        email: String,
        password: String
    ) = repository.userLogin(email,password)

    suspend fun saveLoggedInUser(user: User) = repository.saveUser(user)
}