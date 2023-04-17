package com.wycrm.tyjpropertycompose.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.wycrm.tyjpropertycompose.constants.Constants
import com.wycrm.tyjpropertycompose.network.UserApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
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
    fun provideNetworkJson(): Json = Json {
        ignoreUnknownKeys = true
    }


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


    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    @Named("Cloud")
    fun provideCloudRetrofit(okHttpClient: OkHttpClient, networkJson: Json): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.CLOUD_BASE_URL)
            .addConverterFactory(
                networkJson.asConverterFactory("application/json".toMediaType()),
            )
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    @Named("Chat")
    fun provideChatRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.CHAT_BASE_URL)
            .client(okHttpClient)
            .build()


    @Provides
    @Singleton
    fun provideUserApi(@Named("Cloud") retrofit: Retrofit): UserApi = retrofit.create(UserApi::class.java)
}