package com.subhipandey.android.dishapp.ui.home.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.subhipandey.android.dishapp.data.repository.UserRepo

@Suppress("UNCHECKED_CAST")
class ProfileViewModelFactory(
    private val repository: UserRepo
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProfileViewModel(repository) as T
    }
}