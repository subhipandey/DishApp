package com.subhipandey.android.dishapp.data.repository


import com.subhipandey.android.dishapp.data.network.Api
import com.subhipandey.android.dishapp.data.network.responses.AuthResponse

import retrofit2.Response
import  retrofit2.Callback

class UserRepo {
   suspend fun userLogin(email: String, password: String) : Response <AuthResponse>{
        return Api().userLogin(email , password)
    }
}