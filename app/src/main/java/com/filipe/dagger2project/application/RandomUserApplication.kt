package com.filipe.dagger2project.application

import android.app.Activity
import android.app.Application
import com.filipe.dagger2project.ContextModule
import com.filipe.dagger2project.interfaces.DaggerRandomUserComponent
import com.filipe.dagger2project.interfaces.RandomUserComponent
import timber.log.Timber

class RandomUserApplication: Application() {

    lateinit var randomUserApplicationComponent: RandomUserComponent

    fun get(activity: Activity): RandomUserApplication {
        return activity.application as RandomUserApplication
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        randomUserApplicationComponent = DaggerRandomUserComponent.builder()
                .contextModule(ContextModule(this))
                .build()
    }

    fun getAltRandomUserApplicationComponent(): RandomUserComponent {
        return randomUserApplicationComponent
    }
}