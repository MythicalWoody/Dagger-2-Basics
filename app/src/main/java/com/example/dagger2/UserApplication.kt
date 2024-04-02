package com.example.dagger2

import android.app.Application

class UserApplication: Application() {
    lateinit var appComponent: AppComponent
    lateinit var userRegistrationComponent: UserRegistrationComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().build()
        //userRegistrationComponent = DaggerUserRegistrationComponent.factory().create(3) // here we are creating an application wide content and not just an activity wide
    }                                                                                   // and now the singleton will be application wide
}