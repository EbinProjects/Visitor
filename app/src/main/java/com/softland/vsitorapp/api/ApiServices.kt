package com.softland.vsitorapp.api

import com.softland.vsitorapp.database.models.SaveEntryData
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url


interface ApiServices {
    companion object{

        fun createAccessFlow():ApiServices{
            val logger =
                HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }
            val client: OkHttpClient =
                OkHttpClient.Builder().addInterceptor { chain ->
                    val newRequest: Request = chain.request().newBuilder()
                        .build()
                    chain.proceed(newRequest)
                }.addInterceptor(logger)
                    .build()
            return Retrofit.Builder()
                .baseUrl("https://www.google.co.in/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiServices::class.java)
        }
    }

    /*@POST
    suspend fun deviceRegistration(
        @Url url: String,
        @Body request: DeviceRegistrationRequest
    ): Response<DeviceRegistration>*/


    @GET
    suspend fun entryPersonsData(
        @Url url :String
    ): Response<List<SaveEntryData>>

}