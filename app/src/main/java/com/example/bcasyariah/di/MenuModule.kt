package com.example.bcasyariah.di

import com.example.bcasyariah.data.Service
import com.example.bcasyariah.data.remote.MenuDashboardRemoteDatasource
import com.example.bcasyariah.data.remote.MenuDashboardRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object MenuModule {

    @Singleton
    @Provides
    fun provideMenuDashboardRemoteDatasource(service: Service):
            MenuDashboardRemoteDatasource {
        return MenuDashboardRemoteDatasourceImpl(service)
    }

}