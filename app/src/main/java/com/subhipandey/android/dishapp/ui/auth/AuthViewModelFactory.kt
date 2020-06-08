package com.subhipandey.android.dishapp.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.subhipandey.android.dishapp.data.repository.UserRepo

@Suppress("UNCHECKED_CAST")
class AuthViewModelFactory(
    private val repository: UserRepo
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthViewModel(repository) as T
    }
}