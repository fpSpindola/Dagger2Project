package com.filipe.dagger2project.interfaces

import com.filipe.dagger2project.model.RandomUsers
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query



interface RandomUsersApi {

    @GET("api")
    fun getRandomUsers(@Query("results") size: Int): Call<RandomUsers>
}