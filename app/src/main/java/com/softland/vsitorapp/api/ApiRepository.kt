package com.softland.vsitorapp.api

import com.softland.vsitorapp.database.models.SaveEntryData
import retrofit2.Response
import retrofit2.http.Url
import java.net.CacheRequest
import javax.inject.Inject

class ApiRepository @Inject constructor(val apiServices: ApiServices) {

 /*   suspend fun  deviceRegistrationRequest(
        url: String,
        request: DeviceRegistrationRequest
    ): Response<DeviceRegistration>? {
        return careService?.deviceRegistration(
            url,request
        )
    }*/

    suspend fun entryPersonsData(
        url: String
    ) :Response<List<SaveEntryData>>{
        return apiServices.entryPersonsData(url)
    }
}