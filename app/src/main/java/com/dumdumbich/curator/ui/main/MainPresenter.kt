package com.dumdumbich.curator.ui.main

import com.dumdumbich.curator.ui.navigator.IScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class MainPresenter (private val router: Router, private val screens: IScreens) :
    MvpPresenter<IMainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.mentees())
    }

    fun backClicked() {
        router.exit()
    }

}