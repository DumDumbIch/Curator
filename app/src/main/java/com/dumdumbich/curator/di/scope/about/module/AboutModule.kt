package com.dumdumbich.curator.di.scope.about.module

import com.dumdumbich.curator.di.scope.about.AboutScope
import com.dumdumbich.curator.di.scope.about.IAboutScopeContainer
import com.dumdumbich.curator.ui.App
import dagger.Module
import dagger.Provides

@Module
class AboutModule {

    @AboutScope
    @Provides
    fun aboutScopeContainer(app: App): IAboutScopeContainer = app

}