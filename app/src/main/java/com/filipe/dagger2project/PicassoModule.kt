package com.filipe.dagger2project

import android.content.Context
import com.filipe.dagger2project.interfaces.ApplicationContext
import com.filipe.dagger2project.interfaces.RandomUserApplicationScope
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import javax.inject.Named

@Module(includes = [OkHttpClientModule::class])
class PicassoModule {

    @RandomUserApplicationScope
    @Provides
    fun picasso(@ApplicationContext context: Context, okHttp3Downloader: OkHttp3Downloader): Picasso {
        return Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build()
    }

    @Provides
    fun okHttp3Downloader(okHttpClient: OkHttpClient): OkHttp3Downloader {
        return OkHttp3Downloader(okHttpClient)
    }
}