

package com.lovoo.android.tvmaze.App.di.component

import com.lovoo.android.tvmaze.App.TvMazeApplication
import com.lovoo.android.tvmaze.App.di.builder.ActivityBuilder
import com.lovoo.android.tvmaze.App.di.module.ActivityModule
import com.lovoo.android.tvmaze.App.di.module.ClassModule
import com.lovoo.android.tvmaze.App.di.module.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = arrayOf(AndroidSupportInjectionModule::class, ClassModule::class, NetworkModule::class, ActivityBuilder::class, ActivityModule::class))
@Singleton
interface AppComponent {

    fun inject(app: TvMazeApplication)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: TvMazeApplication): Builder

        fun build(): AppComponent
    }
}