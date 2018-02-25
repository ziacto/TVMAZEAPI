package com.lovoo.android.tvmaze.App.di.builder
import com.lovoo.android.tvmaze.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}