package com.subhipandey.android.dishapp.data.repository


import com.subhipandey.android.dishapp.data.network.Api
import com.subhipandey.android.dishapp.data.network.SafeApiRequest
import com.subhipandey.android.dishapp.data.network.responses.AuthResponse

import retrofit2.Response
import  retrofit2.Callback

class UserRepo : SafeApiRequest() {
   suspend fun userLogin(email: String, password: String) : AuthResponse {
       return apiRequest {Api().userLogin(email,password  ) }

    }
}