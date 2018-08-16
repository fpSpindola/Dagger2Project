package com.filipe.dagger2project

import android.content.Context
import com.filipe.dagger2project.interfaces.ApplicationContext
import com.filipe.dagger2project.interfaces.RandomUserApplicationScope
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ContextModule(private val context: Context) {

    @ApplicationContext
    @RandomUserApplicationScope
    @Provides
    fun context(): Context {
        return context.applicationContext
    }
}