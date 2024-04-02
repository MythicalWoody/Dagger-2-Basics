package com.example.dagger2

import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

@Module /**runtime pr mujhe kuch value pass krni hai to uske
lie mai pehle ek parameter define krunga **/
class NotificationServiceModule( /*private val retryCount : Int*/) { //Now we can safely delete this retryCount because we have declared it inside our component we don't have to pass it via module


//    @Named("Message") //The @Named annotation in Dagger is used to distinguish between multiple bindings of the same type.
    //@Singleton //If we want to make a provide annotation fun sigleton then we just write singleton on it
    @ActivitySchope
    @MessageQualifier  // Custom annotatios reduce chance of typo
    @Provides
    fun getMessageService(retryCount : Int) : NotificationService{
        return MessageService(retryCount)
    }

    @Named("email")
    @Provides
    fun getEmailService() : NotificationService{
        return EmailServices()
    }
}