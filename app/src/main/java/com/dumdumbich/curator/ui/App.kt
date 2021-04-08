package com.dumdumbich.curator.ui

import android.app.Application
import android.util.Log
import com.dumdumbich.curator.di.scope.main.AppComponent
import com.dumdumbich.curator.di.scope.main.DaggerAppComponent
import com.dumdumbich.curator.di.scope.main.module.AppModule
import com.dumdumbich.curator.di.scope.mentees.IMenteesScopeContainer
import com.dumdumbich.curator.di.scope.mentees.MenteesSubcomponent


const val LOG_D_TAG = "DUMDUMBICH_CURATOR"

class App : Application(), IMenteesScopeContainer {

    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    var menteesSubcomponent: MenteesSubcomponent? = null
        private set


    override fun onCreate() {
        Log.d(LOG_D_TAG, "App(): onCreate()")
        super.onCreate()
        instance = this

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()
    }

    fun initMenteesSubcomponent() = appComponent.menteesSubcomponent().also {
        menteesSubcomponent = it
    }

    override fun releaseMenteesScope() {
        menteesSubcomponent = null
    }

}