package com.example.dagger2

import android.content.ContentValues.TAG
import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

interface NotificationService{
    fun send(to: String, from: String, body: String?)
}

@ActivitySchope
class EmailServices @Inject constructor() : NotificationService{ //If we dont use @Inject over here then dagger will not know how to create object regarding this class
    override fun send(to: String, from: String, body: String?) { //yaha pr hum notification srvice se method le rahe hai
        Log.d(TAG, "Sending email") // but hum chahte hai ki hum send ko email fun ke andr apni marzi se edit kr paaye to hum send function ko override kr dete hai
    }
}

class MessageService(private val retryCount : Int) : NotificationService {
    override fun send(to: String, from: String, body: String?) {
        Log.d("retry","Message Sent - Retry Count = $retryCount")
    }
}