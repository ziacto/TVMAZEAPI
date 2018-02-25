package com.lovoo.android.tvmaze.App.di.builder
import com.lovoo.android.tvmaze.MainActivity
import com.lovoo.android.tvmaze.ui.ShowDetail.DetailShowActivity
import com.lovoo.android.tvmaze.ui.detail.EpisodeDetailsActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity
    @ContributesAndroidInjector
    abstract fun bindEpisodeDetailsActivity(): EpisodeDetailsActivity
    @ContributesAndroidInjector
    abstract fun bindDetailShowActivity(): DetailShowActivity
}