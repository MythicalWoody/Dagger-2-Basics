package com.example.dagger2

import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@ActivitySchope
@Component(dependencies = [AppComponent::class],modules = [UserRepositoryModule::class,NotificationServiceModule::class])
interface UserRegistrationComponent {
//    fun getUserRegistrationService() : UserRegistrationService //ab in methods ki koi zarurat nahi coz ab sara kaam inject function krega
//    fun getEmailService() : EmailServices
    fun inject(mainActivity: MainActivity)
    /** brackets ke andr humne is object ka consumer pass kr diya hai mtlb yaha pr inject krna hai
     so this means ki jis jis bhi field pr @Inject annotation lagi wo object mujhe provide kr do mere consumer me */

    @Component.Factory
    interface Factory{ // yaha pr hum bata rahe ki jub bhi dagger is UserRegistrationComponent is component ko banayega to is factory ka use krna
        fun create(@BindsInstance retryCount : Int, appComponent: AppComponent) : UserRegistrationComponent
    }
}