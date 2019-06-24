package com.jinwoo.festa.presentation.di.module

import com.jinwoo.festa.data.Api
import com.jinwoo.festa.data.ApiClient
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun provideApiClient(api: Api) = ApiClient(api)
}