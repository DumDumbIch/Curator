package com.dumdumbich.curator.ui.pages

import com.dumdumbich.curator.ui.navigator.IScreens
import com.dumdumbich.curator.utils.debug.IDebug
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import moxy.MvpView
import javax.inject.Inject
import javax.inject.Named

abstract class PagePresenter<T : MvpView> : MvpPresenter<T>(), IDebug {

    @field:Named("ui")
    @Inject
    lateinit var uiScheduler: Scheduler

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens


    fun closeScreen(): Boolean {
        router.exit()
        return true
    }

}