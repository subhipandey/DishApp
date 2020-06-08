package com.subhipandey.android.dishapp.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.subhipandey.android.dishapp.R
import com.subhipandey.android.dishapp.data.database.AppDatabase
import com.subhipandey.android.dishapp.data.database.entities.User
import com.subhipandey.android.dishapp.data.network.Api
import com.subhipandey.android.dishapp.data.repository.UserRepo
import com.subhipandey.android.dishapp.databinding.ActivityLoginBinding
import com.subhipandey.android.dishapp.ui.home.HomeActivity
import com.subhipandey.android.dishapp.util.hide
import com.subhipandey.android.dishapp.util.show
import com.subhipandey.android.dishapp.util.snackbar
import com.subhipandey.android.dishapp.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val api = Api()
        val db = AppDatabase(this)
        val repository = UserRepo(api, db)
        val factory = AuthViewModelFactory(repository)

      val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this, factory).get(AuthViewModel::class.java)

        binding.viewmodel = viewModel

        viewModel.authListener = this

        viewModel.getLoggedInUser().observe(this, Observer {user ->
            if (user != null){
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })
    }

    override fun onStarted() {
       progress_bar.show()
    }

    override fun onSuccess(user : User){
        progress_bar.hide()



    }


    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)

    }
}
