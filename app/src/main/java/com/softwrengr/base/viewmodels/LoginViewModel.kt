package com.softwrengr.base.viewmodels

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.google.gson.JsonObject
import com.softwrengr.base.baseClasses.BaseViewModel
import com.softwrengr.base.data.datautils.DataState
import com.softwrengr.base.data.usecases.LoginUsecase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUsecase: LoginUsecase,
    ) : BaseViewModel() {


        fun login(){
            viewModelScope.launch {

                loginUsecase.invoke(getRequest()).collect { dataState ->
                    when(dataState){
                        is DataState.Success -> {
                            Log.d("response","See the response "+dataState.data.message)
                        }
                        is DataState.Error ->{

                        }
                    }
                }
            }
        }


    private fun getRequest() : JsonObject{
        val jsonObject = JsonObject()
        jsonObject.addProperty("email","softwreng@gmail.com")
        jsonObject.addProperty("username","jahfdsu7fdsyhf2")
        jsonObject.addProperty("fcm_token","Abdulahkhan")
        jsonObject.addProperty("device_id","fadsfafs2")

        Log.d("request",jsonObject.toString())
        return jsonObject
    }
}