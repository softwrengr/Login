package com.softwrengr.base.data.api;

import com.google.gson.JsonObject
import com.softwrengr.base.data.remote.ApiResponse
import com.softwrengr.base.models.LoginModel
import org.json.JSONObject
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("rest_api/signup")
    suspend fun login(@Body jsonObject: JsonObject): Response<LoginModel>

    @POST("rest_api/signup")
    suspend fun test(@Body jsonObject: JsonObject): ApiResponse<LoginModel>


    companion object {
        const val BASE_API_URL = "https://dailytradeview.com/"
    }
}
