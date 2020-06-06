package com.subhipandey.android.dishapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.subhipandey.android.dishapp.data.repository.UserRepo

class AuthViewModel : ViewModel() {

    var email: String? = null
    var password: String? = null
    var authListener: AuthListener? = null

    fun onLoginButtonClick(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
             authListener?.onFailure("Invalid email or password")
            return
        }
       val loginResponse = UserRepo().userLogin(email!!, password!!)
        authListener?.onSuccess(loginResponse)

    }
}