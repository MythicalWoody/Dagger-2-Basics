package com.example.dagger2

import android.util.Log

interface AnalyticsService {
    fun trackEvent(eventName: String , eventType: String)
}

class Mixpanel : AnalyticsService{
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("Mixpanel", "Mixpanel $eventName $eventType")
    }
}

class FirebaseAnalytics: AnalyticsService{
    override fun trackEvent(eventName: String, eventType: String) {
        Log.d("Firebase", "Firebase $eventName , $eventType")
    }
}