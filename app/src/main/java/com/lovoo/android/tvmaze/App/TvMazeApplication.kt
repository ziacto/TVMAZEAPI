package com.lovoo.android.tvmaze.App

import android.app.Activity
import android.app.Application
import com.lovoo.android.tvmaze.App.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class TvMazeApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var mainInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = mainInjector
    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this)
    }
}