package com.dumdumbich.curator.ui.pages.about

import com.dumdumbich.curator.di.scope.about.IAboutScopeContainer
import com.dumdumbich.curator.domain.interactor.IFeedBack
import com.dumdumbich.curator.ui.navigator.IScreens
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject

class AboutPresenter : MvpPresenter<IAboutView>() {

    @Inject
    lateinit var aboutScopeContainer: IAboutScopeContainer

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    @Inject
    lateinit var feedback: IFeedBack

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun sendFeedBack(message: String) {
        router.navigateTo(screens.feedback(feedback,message))
    }

    fun closeScreen(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        aboutScopeContainer.releaseAboutScope()
        super.onDestroy()
    }

}

