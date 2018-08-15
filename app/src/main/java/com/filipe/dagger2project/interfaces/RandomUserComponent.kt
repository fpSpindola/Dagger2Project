package com.filipe.dagger2project.interfaces

import com.filipe.dagger2project.PicassoModule
import com.filipe.dagger2project.RandomUserModule
import com.squareup.picasso.Picasso
import dagger.Component

@RandomUserApplicationScope
@Component(modules = [RandomUserModule::class, PicassoModule::class])
interface RandomUserComponent {
    fun getRandomUserService(): RandomUsersApi
    fun getPicasso(): Picasso
}