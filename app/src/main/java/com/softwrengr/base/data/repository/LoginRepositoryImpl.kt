package com.softwrengr.base.data.repository;

import android.util.Log
import androidx.annotation.WorkerThread
import com.google.gson.JsonObject
import com.softwrengr.base.data.api.ApiService
import com.softwrengr.base.data.datautils.DataState
import com.softwrengr.base.data.remote.message
import com.softwrengr.base.data.remote.onErrorSuspend
import com.softwrengr.base.data.remote.onExceptionSuspend
import com.softwrengr.base.data.remote.onSuccessSuspend
import com.softwrengr.base.models.LoginModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import java.lang.Exception
import javax.inject.Inject


class LoginRepositoryImpl @Inject constructor(
    private val apiService: ApiService) : LoginRepository {


    override suspend fun login(jsonObject: JsonObject): Flow<DataState<LoginModel>> {

        return flow {
            apiService.test(jsonObject).apply {

                this.onSuccessSuspend {

                    data?.let {
                        emit(DataState.success(it))
                    }

                }.onErrorSuspend {

                   emit(DataState.error<LoginModel>(message()))

                }.onExceptionSuspend {

                    if(this.exception is IOException){
                      emit(DataState.error<LoginModel>("No Internet Connection"))
                    }
                    else{
                        emit(DataState.error<LoginModel>("Something went wrong"))
                    }

                }
            }
        }

    }


}
