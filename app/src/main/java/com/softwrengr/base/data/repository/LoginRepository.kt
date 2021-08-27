package com.softwrengr.base.data.repository;

import com.google.gson.JsonObject
import com.softwrengr.base.data.datautils.DataState
import com.softwrengr.base.models.LoginModel

import kotlinx.coroutines.flow.Flow


interface LoginRepository {

    suspend fun login(jsonObject: JsonObject): Flow<DataState<LoginModel>>
}
