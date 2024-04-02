package com.example.dagger2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject //ye annotaion batati hai ki ye wali jo field hai wo yaha pr inject krna hai
    lateinit var userRegistrationService : UserRegistrationService
    @Inject
    lateinit var emailServices1: EmailServices // here we see that for both emailservice1 and 2 EmailServices is being called.
    @Inject
    lateinit var emailServices2: EmailServices // and now after adding singleton to the class and the component from which it is being called, we are getting only one instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

/**        val emailServices = EmailServices() // ab mujhe jaha bhi user registration service ka object chahiye hoga
//        val userRepository = UserRepository() // waha mujhe baar baar ye objects banane honge or unhe pass krna hoga
//
//        val userRegistrationService = UserRegistrationService(emailServices, userRepository)
 */

/** jo hamari class thi dagger uske naam ke aage Dagger append kr deta hai
//        val userRegistrationService = DaggerUserRegistrationComponent.builder().build().getUserRegistrationService() // Similarly ye lines bhi ab inject function sambhal lega
       val emailService = DaggerUserRegistrationComponent.builder().build().getEmailService()
***/

        val appComponent = (application as UserApplication).appComponent   //userRegistrationComponent // Retrieve the UserRegistrationComponent instance
        val userRegistrationComponent = DaggerUserRegistrationComponent.factory().create(3,appComponent)
        //DaggerUserRegistrationComponent.factory().create(3) : using factory but not having application wide scope
            //.notificationServiceModule(NotificationServiceModule(3)) : Not using Factory
            /**Here Dagger automatically generated module objects
             but in case when we want to pass certain parameters with it we create a dynamic path to tell dagger to create objects this way **/
        userRegistrationComponent.inject(this) //here we have called our inject fun from UserRegistrationComponent and passed the context
        userRegistrationService.registerUser("To@gmail.com", "12345678")
    }
}