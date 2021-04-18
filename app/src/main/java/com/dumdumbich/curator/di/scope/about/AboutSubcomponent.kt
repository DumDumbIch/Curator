package com.dumdumbich.curator.di.scope.about

import com.dumdumbich.curator.di.scope.about.module.AboutModule
import com.dumdumbich.curator.ui.pages.about.AboutPresenter
import dagger.Subcomponent


@AboutScope
@Subcomponent(
    modules = [
        AboutModule::class
    ]
)
interface AboutSubcomponent {

    fun inject(aboutPresenter: AboutPresenter)

}