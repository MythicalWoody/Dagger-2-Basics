package com.example.dagger2

import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class UserRepositoryModule {

//    @Binds //jbhi mujhe userRepository ki zarurat padegi to fir ye wala function mujhe provide krega
//    abstract fun getFirebaseRepository(fireBaseRepository: FireBaseRepository) : UserRepository //kyoki hume userrepository ka objext chahiye to iska return type bhi wahi hoga


    //Binding methods are annotated with @Binds and specify the type of dependency
    //being provided and the implementation that provides it.

    @Binds //The @Binds annotation tells Dagger that this method provides an implementation for the specified type.
    @ActivitySchope
    //@Singleton In case of binds we can use singleton annotation over here as well
    abstract fun getSqlRepository(sqlRepository: SQLRepository): UserRepository

}

