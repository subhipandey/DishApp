package com.subhipandey.android.dishapp.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.subhipandey.android.dishapp.data.network.Api
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import  retrofit2.Callback

class UserRepo {
    fun userLogin(email: String, password: String) : LiveData<String>{
        val loginResponse = MutableLiveData<String>()
        Api().userLogin(email, password)
            .enqueue(object : Callback<ResponseBody>{
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    loginResponse.value = t.message
                }

                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if(response.isSuccessful){
                        loginResponse.value = response.errorBody()?.string()
                    }
                }

            })
        return loginResponse
    }
}