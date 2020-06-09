package com.subhipandey.android.dishapp.ui.home.profile

import androidx.lifecycle.ViewModel
import com.subhipandey.android.dishapp.data.repository.UserRepo

class ProfileViewModel (
    repository: UserRepo
) : ViewModel() {

    val user = repository.getUser()
}