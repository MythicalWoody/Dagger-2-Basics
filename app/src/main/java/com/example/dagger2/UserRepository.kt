package com.example.dagger2

import android.content.ContentValues.TAG
import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

interface UserRepository{
    fun saveUser(email: String, password: String)
}

// @Singleton // in case of binds annotation with whichever class we bind our object we mark it as singleton
@ActivitySchope
class SQLRepository @Inject constructor(private val analyticsService: AnalyticsService) : UserRepository{
    override fun saveUser(email: String, password: String) {
        Log.d(TAG,"Saving user $email $password")
        analyticsService.trackEvent("Save User", "CREATE")
    }
}

class FireBaseRepository(val analyticsService: AnalyticsService) : UserRepository {
    override fun saveUser(email: String, password: String) {
        Log.d(TAG,"Saving user $email $password")
        analyticsService.trackEvent("Save User", "CREATE")
    }
}