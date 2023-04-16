package com.wycrm.tyjpropertycompose.di

import com.wycrm.tyjpropertycompose.util.ConnectivityManagerNetworkMonitor
import com.wycrm.tyjpropertycompose.util.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsNetworkMonitor(
        networkMonitor: ConnectivityManagerNetworkMonitor,
    ): NetworkMonitor
}