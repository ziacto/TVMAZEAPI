package com.lovoo.android.tvmaze.App.di.module

import com.lovoo.android.tvmaze.ui.ShowDetail.DetailShowMvpPresenter
import com.lovoo.android.tvmaze.ui.ShowDetail.DetailShowMvpView
import com.lovoo.android.tvmaze.ui.ShowDetail.DetailShowPresenter
import com.lovoo.android.tvmaze.ui.main.MainMvpPresenter
import com.lovoo.android.tvmaze.ui.main.MainMvpView
import com.lovoo.android.tvmaze.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule {
    @Provides
    fun provideMainPresenter(presenter: MainPresenter<MainMvpView>): MainMvpPresenter<MainMvpView> = presenter
    @Provides
    fun provideShowPresenter(presenter: DetailShowPresenter<DetailShowMvpView>): DetailShowMvpPresenter<DetailShowMvpView> = presenter
}