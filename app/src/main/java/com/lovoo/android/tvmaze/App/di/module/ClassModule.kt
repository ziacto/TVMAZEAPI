package com.lovoo.android.tvmaze.App.di.module

import android.content.Context
import com.lovoo.android.tvmaze.App.TvMazeApplication
import com.lovoo.android.tvmaze.data.AppManager
import com.lovoo.android.tvmaze.data.api.ApiCallManager
import com.lovoo.android.tvmaze.data.api.ApiCalls
import com.lovoo.android.tvmaze.data.api.ApiInterface
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ClassModule {

    @Provides
    fun provideContext(app: TvMazeApplication): Context = app.applicationContext

    @Singleton
    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder().build()

    @Provides
    @Singleton
    fun provideApiInterface(apiCall: ApiCalls): ApiInterface = apiCall

    @Provides
    @Singleton
    fun provideAppManager(appManager: ApiCallManager): AppManager = appManager


}