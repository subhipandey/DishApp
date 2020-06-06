package com.subhipandey.android.dishapp.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.subhipandey.android.dishapp.data.repository.UserRepo
import com.subhipandey.android.dishapp.util.Coroutines

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

        Coroutines.main {
            val response = UserRepo().userLogin(email!!, password!!)
            if(response.isSuccessful){
                authListener?.onSuccess(response.body()?.user!!)
            }else {
                authListener?.onFailure("Error Code: ${response.code()}")
            }
        }


    }
}