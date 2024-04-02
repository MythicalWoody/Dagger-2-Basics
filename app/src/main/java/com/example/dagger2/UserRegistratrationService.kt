package com.example.dagger2

import javax.inject.Inject
import javax.inject.Named

//hume is class pr bhi @inject annotation lagani hogi or iske andr jo objects hai unki class pr bhi
class UserRegistrationService @Inject constructor( // jobhi iski req dependenciers hai wo hume iske constructor se milegi
//    @Named("Message") //here we are telling the dagger that when it gives us the Notification service object it should give us the Message one.
    @MessageQualifier
    private val notificationService: NotificationService, // jobhi ye class ka object banaega use hume userRepo and emailService ka objet pass krna hoga
    private val userRepository: UserRepository) {

    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        notificationService.send(email, "noreply@gmail.com", "User registered")
    }
}