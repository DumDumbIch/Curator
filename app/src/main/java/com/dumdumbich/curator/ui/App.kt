package com.dumdumbich.curator.ui

import android.app.Application
import com.dumdumbich.curator.di.scope.about.AboutSubcomponent
import com.dumdumbich.curator.di.scope.about.IAboutScopeContainer
import com.dumdumbich.curator.di.scope.main.AppComponent
import com.dumdumbich.curator.di.scope.main.DaggerAppComponent
import com.dumdumbich.curator.di.scope.main.module.AppModule
import com.dumdumbich.curator.di.scope.mentees.IMenteesScopeContainer
import com.dumdumbich.curator.di.scope.mentees.MenteesSubcomponent
import com.dumdumbich.curator.di.scope.tables.ITablesScopeContainer
import com.dumdumbich.curator.di.scope.tables.TablesSubcomponent
import com.dumdumbich.curator.utils.debug.DEBUG_App
import com.dumdumbich.curator.utils.debug.IDebug


class App : Application(), IMenteesScopeContainer, IAboutScopeContainer, ITablesScopeContainer, IDebug {

    companion object {
        lateinit var instance: App
    }

    lateinit var appComponent: AppComponent

    var menteesSubcomponent: MenteesSubcomponent? = null
        private set

    var aboutSubcomponent: AboutSubcomponent? = null
        private set

    var tablesSubcomponent: TablesSubcomponent? = null
        private set


    override fun onCreate() {
        debugMessage(DEBUG_App, "App(): onCreate()")
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

    fun initAboutSubcomponent() = appComponent.aboutSubcomponent().also {
        aboutSubcomponent = it
    }

    override fun releaseAboutScope() {
        aboutSubcomponent = null
    }

    fun initTablesSubcomponent() = appComponent.tablesSubcomponent().also {
        tablesSubcomponent = it
    }

    override fun releaseTablesScope() {
        tablesSubcomponent = null
    }

}