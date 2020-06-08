package com.subhipandey.android.dishapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.subhipandey.android.dishapp.data.repository.UserRepo
import com.subhipandey.android.dishapp.util.ApiException
import com.subhipandey.android.dishapp.util.Coroutines

class AuthViewModel(
   private val repository: UserRepo
) : ViewModel() {

    var email: String? = null
    var password: String? = null
    var authListener: AuthListener? = null

    fun getLoggedInUser() = repository.getUser()

    fun onLoginButtonClick(view: View) {
        authListener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            authListener?.onFailure("Invalid email or password")
            return
        }

        Coroutines.main {
            try {
                val authResponse = repository.userLogin(email!!, password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }
                authListener?.onFailure(authResponse.message!!)
            } catch (e: ApiException) {
                authListener?.onFailure(e.message!!)
            }
        }


    }
}