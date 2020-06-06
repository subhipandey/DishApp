package com.subhipandey.android.dishapp.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.subhipandey.android.dishapp.R
import com.subhipandey.android.dishapp.data.database.entities.User
import com.subhipandey.android.dishapp.databinding.ActivityLoginBinding
import com.subhipandey.android.dishapp.util.hide
import com.subhipandey.android.dishapp.util.show
import com.subhipandey.android.dishapp.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.viewmodel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
       progress_bar.show()
    }

    override fun onSuccess(user : User){
        progress_bar.hide()
        toast("${user.name} is Logged In")

    }


    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)

    }
}
