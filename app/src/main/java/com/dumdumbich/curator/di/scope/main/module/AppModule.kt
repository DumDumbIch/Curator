package com.dumdumbich.curator.di.scope.main.module

import com.dumdumbich.curator.di.scope.main.MainScope
import com.dumdumbich.curator.ui.App
import dagger.Module
import dagger.Provides

@Module
class AppModule(val app: App) {

    @MainScope
    @Provides
    fun app(): App = app

}