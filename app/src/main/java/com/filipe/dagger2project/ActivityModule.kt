package com.filipe.dagger2project

import android.app.Activity
import android.content.Context
import com.filipe.dagger2project.interfaces.RandomUserApplicationScope
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ActivityModule {

    lateinit var context: Context

    fun ActivityModule(context: Activity){
        this.context = context
    }

    @Named("activity_context")
    @RandomUserApplicationScope
    @Provides
    fun context(): Context{
        return context
    }
}