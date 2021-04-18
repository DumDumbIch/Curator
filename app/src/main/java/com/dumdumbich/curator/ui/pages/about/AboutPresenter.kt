package com.dumdumbich.curator.ui.pages.about

import android.content.Intent
import com.dumdumbich.curator.R
import com.dumdumbich.curator.di.scope.about.IAboutScopeContainer
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import javax.inject.Inject
class AboutPresenter : MvpPresenter<IAboutView>() {

    @Inject
    lateinit var aboutScopeContainer: IAboutScopeContainer

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun sendFeedBack(message: String) = Intent(Intent.ACTION_SEND).apply {
        type = "plain/text"
        putExtra(Intent.EXTRA_EMAIL, R.string.developer_email)
        putExtra(Intent.EXTRA_SUBJECT, R.string.email_subject_feedback)
        putExtra(Intent.EXTRA_TEXT, message)
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

