package com.filipe.dagger2project

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule {

    lateinit var context: Context

    fun ContextModule(context: Context){
        this.context = context
    }

    @Provides
    fun context(): Context {
        return context.applicationContext
    }
}