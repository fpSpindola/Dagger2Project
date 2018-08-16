package com.filipe.dagger2project

import android.os.Bundle
import android.os.Message
import android.support.annotation.NonNull
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.filipe.dagger2project.MainActivityFeature.DaggerMainActivityComponent
import com.filipe.dagger2project.MainActivityFeature.MainActivityComponent
import com.filipe.dagger2project.MainActivityFeature.MainActivityModule
import com.filipe.dagger2project.adapter.RandomUserAdapter
import com.filipe.dagger2project.application.RandomUserApplication
import com.filipe.dagger2project.interfaces.DaggerRandomUserComponent
import com.filipe.dagger2project.interfaces.RandomUserComponent
import com.filipe.dagger2project.interfaces.RandomUsersApi
import com.filipe.dagger2project.model.RandomUsers
import com.google.gson.GsonBuilder
import com.jakewharton.picasso.OkHttp3Downloader
import com.squareup.picasso.OkHttpDownloader
import com.squareup.picasso.Picasso

import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
import java.io.File

class MainActivity : AppCompatActivity() {

    lateinit var retrofit: Retrofit
    lateinit var recyclerView: RecyclerView
    lateinit var mAdapter: RandomUserAdapter

    lateinit var picasso: Picasso

    lateinit var randomUsersApi: RandomUsersApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        val daggerRandomUserComponent = DaggerRandomUserComponent
                .builder()
                .contextModule(ContextModule(this))
                .build()

        val picasso = daggerRandomUserComponent.getPicasso()
        val randomapi = daggerRandomUserComponent.getRandomUserService()

        val mainActivityComponent: MainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(MainActivityModule(this))
                .randomUserComponent(RandomUserApplication().get(this).getAltRandomUserApplicationComponent())
                .build()

        randomUsersApi = mainActivityComponent.getRandomUserService()
        mAdapter = mainActivityComponent.getRandomUserAdapter()

        populateUsers()
    }

    private fun afterActivityLevelComponent() {
        val mainActivityComponent: MainActivityComponent = DaggerMainActivityComponent.builder()
                .mainActivityModule(MainActivityModule(this))
                .randomUserComponent(RandomUserApplication().get(this).getAltRandomUserApplicationComponent())
                .build()
        randomUsersApi = mainActivityComponent.getRandomUserService()
        mAdapter = mainActivityComponent.getRandomUserAdapter()
    }

    private fun afterDagger() {
        val daggerRandomUserComponent = DaggerRandomUserComponent.builder()
                .contextModule(ContextModule(this))
                .build()
        picasso = daggerRandomUserComponent.getPicasso()
        randomUsersApi = daggerRandomUserComponent.getRandomUserService()
    }

    private fun beforeDagger2() {
        val gsonBuilder: GsonBuilder = GsonBuilder()
        val gson = gsonBuilder.create()

        Timber.plant(Timber.DebugTree())

        val cacheFile: File = File(this.cacheDir, "HttpCache")
        cacheFile.mkdirs()

        val cache: Cache = Cache(cacheFile, 10 * 1000 * 1000)

        val httpLoggingInterceptor = HttpLoggingInterceptor(object: HttpLoggingInterceptor.Logger {
            override fun log(@NonNull message: String) {
                Timber.i(message)
            }
        })

        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okHttpClient = OkHttpClient()
                .newBuilder()
                .addInterceptor(httpLoggingInterceptor)
                .build()

        val okHttpDownloader: OkHttp3Downloader = OkHttp3Downloader(okHttpClient)

        picasso = Picasso.Builder(this).downloader(okHttpDownloader).build()

        retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    private fun initViews(){
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun populateUsers() {
        val randomUsersCall: Call<RandomUsers> = getRandomUserService().getRandomUsers(10)
        randomUsersCall.enqueue(object: Callback<RandomUsers> {
            override fun onFailure(call: Call<RandomUsers>?, t: Throwable?) {
                Timber.i(t!!.message)
            }

            override fun onResponse(call: Call<RandomUsers>?, response: Response<RandomUsers>) {
                if(response.isSuccessful()) {
                    mAdapter = RandomUserAdapter(response.body()!!.results, null)
//                    mAdapter.setItems(response.body()!!.results)
                    recyclerView.adapter = mAdapter

                }
            }

        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun getRandomUserService(): RandomUsersApi {
        return randomUsersApi
    }
}
