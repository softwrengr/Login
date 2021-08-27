package com.softwrengr.base.data.usecases
import com.google.gson.JsonObject
import com.softwrengr.base.data.repository.LoginRepository
import javax.inject.Inject


class LoginUsecase
@Inject constructor(private val repository: LoginRepository) {

    suspend   fun login(jsonObject: JsonObject) = repository.login(jsonObject)

    suspend operator  fun invoke(jsonObject: JsonObject) = repository.login(jsonObject)

}
