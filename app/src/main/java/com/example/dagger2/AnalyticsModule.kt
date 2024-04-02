package com.example.dagger2

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AnalyticsModule {

    @Provides
    @Singleton
    fun getAnalyticsService() : AnalyticsService{
        return Mixpanel()
    }
}