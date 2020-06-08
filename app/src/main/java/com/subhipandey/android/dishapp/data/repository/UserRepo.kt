package com.subhipandey.android.dishapp.data.repository


import com.subhipandey.android.dishapp.data.database.AppDatabase
import com.subhipandey.android.dishapp.data.database.entities.User
import com.subhipandey.android.dishapp.data.network.Api
import com.subhipandey.android.dishapp.data.network.SafeApiRequest
import com.subhipandey.android.dishapp.data.network.responses.AuthResponse

import retrofit2.Response
import  retrofit2.Callback

class UserRepo(
    private val api: Api,
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getUser()
}