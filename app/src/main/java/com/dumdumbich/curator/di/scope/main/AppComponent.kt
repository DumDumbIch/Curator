package com.dumdumbich.curator.di.scope.main

import com.dumdumbich.curator.di.scope.about.AboutSubcomponent
import com.dumdumbich.curator.di.scope.main.module.AppModule
import com.dumdumbich.curator.di.scope.main.module.DriverModule
import com.dumdumbich.curator.di.scope.main.module.NavigationModule
import com.dumdumbich.curator.di.scope.main.module.SchedulerModule
import com.dumdumbich.curator.di.scope.mentees.MenteesSubcomponent
import com.dumdumbich.curator.di.scope.tables.TablesSubcomponent
import com.dumdumbich.curator.ui.main.MainActivity
import com.dumdumbich.curator.ui.main.MainPresenter
import dagger.Component


@MainScope
@Component(
    modules = [
        AppModule::class,
//        DatabaseModule::class,
        NavigationModule::class,
//        NetworkModule::class,
//        ResourceModule::class,
        SchedulerModule::class,
        DriverModule::class
    ]
)
interface AppComponent {

    fun menteesSubcomponent(): MenteesSubcomponent
    fun aboutSubcomponent(): AboutSubcomponent
    fun tablesSubcomponent(): TablesSubcomponent
    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)

}