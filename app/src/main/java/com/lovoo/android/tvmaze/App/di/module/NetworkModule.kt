package com.lovoo.android.tvmaze.App.di.module

import android.content.Context
import com.lovoo.android.tvmaze.BuildConfig
import com.lovoo.android.tvmaze.constants.Configs
import com.lovoo.android.tvmaze.data.api.ApiInterceptor
import com.lovoo.android.tvmaze.data.api.RestApi
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton



@Module
class NetworkModule {

    @Provides
    fun provideCacheFile(context: Context): Cache {
        val baseDir = context.cacheDir
        val cacheDir = File(baseDir, "HttpResponseCache")
        return Cache(cacheDir, 5 * 1024 * 1024)
    }
    @Provides
    @Singleton
    fun provideMoshiConverterLibrary(moshi: Moshi): MoshiConverterFactory {
        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    @Singleton
    fun providesRxJava2CallAdapter(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(cache: Cache?, apiKeyInterceptor: ApiInterceptor): OkHttpClient {
        val okHttpClientBuilder = OkHttpClient.Builder()

        if (cache != null) {
            okHttpClientBuilder.cache(cache)
        }

        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addInterceptor(logging)
        }

        okHttpClientBuilder
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)

        okHttpClientBuilder.addInterceptor(apiKeyInterceptor)

        return okHttpClientBuilder.build()
    }

    @Provides
    @Singleton
    fun provideRestApiHelper(
            okHttpClient: OkHttpClient,
            moshiConverterFactory: MoshiConverterFactory,
            rxJava2CallAdapterFactory: RxJava2CallAdapterFactory): RestApi {
        val builder = Retrofit.Builder()
                .baseUrl(Configs.BASE_URL)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .addConverterFactory(moshiConverterFactory)
        val retrofit = builder.client(okHttpClient).build()
        return retrofit.create(RestApi::class.java)
    }
}