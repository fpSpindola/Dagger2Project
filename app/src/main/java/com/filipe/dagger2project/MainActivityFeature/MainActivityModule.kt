package com.filipe.dagger2project.MainActivityFeature

import com.filipe.dagger2project.MainActivity
import com.filipe.dagger2project.adapter.RandomUserAdapter
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val mainActivity: MainActivity) {

    @Provides
    @MainActivityScope
    fun randomUserAdapter(picasso: Picasso): RandomUserAdapter {
        return RandomUserAdapter(null, mainActivity, picasso)
    }
}