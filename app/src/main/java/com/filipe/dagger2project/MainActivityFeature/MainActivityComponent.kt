package com.filipe.dagger2project.MainActivityFeature

import com.filipe.dagger2project.MainActivity
import com.filipe.dagger2project.adapter.RandomUserAdapter
import com.filipe.dagger2project.interfaces.RandomUserComponent
import com.filipe.dagger2project.interfaces.RandomUsersApi
import dagger.Component

@Component(modules = [MainActivityModule::class], dependencies = [RandomUserComponent::class])
@MainActivityScope
interface MainActivityComponent {

    fun injectMainActivity(mainActivity: MainActivity)
}