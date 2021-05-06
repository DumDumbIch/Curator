package com.dumdumbich.curator.di.scope.main.module

import com.dumdumbich.curator.di.scope.main.MainScope
import com.dumdumbich.curator.driver.EMail
import com.dumdumbich.curator.domain.interactor.IFeedBack
import dagger.Module
import dagger.Provides


@Module
class DriverModule {

    @MainScope
    @Provides
    fun feedback(): IFeedBack = EMail()

}