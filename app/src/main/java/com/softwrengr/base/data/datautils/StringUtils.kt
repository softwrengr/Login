package com.softwrengr.base.data.datautils

import android.app.Application

class StringUtils(val appContext: Application) {
    fun noNetworkErrorMessage() = "No Internet"
    fun somethingWentWrong() = "Something went wrong"
}
