package com.wycrm.tyjpropertycompose.network

import com.wycrm.tyjpropertycompose.constants.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient =
        run {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
            OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
        }


    @Provides
    @Singleton
    @Named("Cloud")
    fun provideCloudRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.CLOUD_BASE_URL)
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    @Named("Chat")
    fun provideChatRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.COMMUNICATION_BASE_URL)
            .client(okHttpClient)
            .build()

}