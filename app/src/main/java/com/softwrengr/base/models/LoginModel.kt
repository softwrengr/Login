package com.softwrengr.base.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize

@Parcelize
class LoginModel(
    @Expose val success: String,
    @Expose val response_code: String,
    @Expose val message: String,
) :Parcelable

