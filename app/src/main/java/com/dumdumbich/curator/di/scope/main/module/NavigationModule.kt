package com.dumdumbich.curator.di.scope.main.module

import com.dumdumbich.curator.di.scope.main.MainScope
import com.dumdumbich.curator.ui.navigator.AndroidScreens
import com.dumdumbich.curator.ui.navigator.IScreens
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.Module
import dagger.Provides

@Module
class NavigationModule {

    val cicerone: Cicerone<Router> = Cicerone.create()

    @Provides
    fun cicerone(): Cicerone<Router> = cicerone

    @MainScope
    @Provides
    fun navigatorHolder(): NavigatorHolder = cicerone.getNavigatorHolder()

    @MainScope
    @Provides
    fun router(): Router = cicerone.router

    @MainScope
    @Provides
    fun screens(): IScreens = AndroidScreens()

}