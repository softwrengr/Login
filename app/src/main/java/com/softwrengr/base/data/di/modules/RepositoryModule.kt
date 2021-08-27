package com.softwrengr.base.data.di.modules

import android.app.Application
import com.softwrengr.base.data.api.ApiService
import com.softwrengr.base.data.datautils.StringUtils
import com.softwrengr.base.data.repository.LoginRepository
import com.softwrengr.base.data.repository.LoginRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * The Dagger Module for providing repository instances.
 * @author Wajahat Karim
 */
@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideStringUtils(app: Application): StringUtils {
        return StringUtils(app)
    }

    @Singleton
    @Provides
    fun provideImagineRepository(stringUtils: StringUtils, apiService: ApiService): LoginRepository {
        return LoginRepositoryImpl(apiService)
    }
}
