package com.dumdumbich.curator.ui.main

import com.dumdumbich.curator.ui.navigator.IScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter : MvpPresenter<IMainView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.mentees())
    }

    fun backClicked() {
        router.exit()
    }

}