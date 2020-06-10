package com.subhipandey.android.dishapp.data.network

import com.subhipandey.android.dishapp.data.network.responses.AuthResponse
import com.subhipandey.android.dishapp.data.network.responses.QuoteResponse
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Api {
    @FormUrlEncoded
    @POST("login")
    suspend fun userLogin(
        @Field("email") email: String,
        @Field("password") password: String
    ): Response<AuthResponse>

    @GET("quotes")
    suspend fun getQuotes() : Response<QuoteResponse>


    companion object{
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ) : Api{

            val okkhttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okkhttpclient)
                .baseUrl("")
                .addConverterFactory((GsonConverterFactory.create()))
                .build()
                .create(Api::class.java)
        }
    }
}